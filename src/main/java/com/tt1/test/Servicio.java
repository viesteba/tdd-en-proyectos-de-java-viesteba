package com.tt1.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/**
 * Gestiona la lógica de negocio del sistema de tareas.
 * <p>
 * Permite crear una tarea en base a un nombre y una fecha límite.
 * Además, permite agregar direcciones de correo electrónico a la agenda,
 * marcar tareas como finalizadas y consultar las tareas pendientes.
 * </p>
 * <p>
 * Cada operación que realiza comprueba si hay tareas sin completar cuya fecha límite haya vencido,
 * enviando un correo de alerta a todas las direcciones de la agenda.
 * </p>
 * @author Víctor Esteban Chacobo
 * @version 1.0
 * @since 1.0
 * @see IRepositorio
 * @see IMailerStub
 */
public class Servicio {
    /**
     * Repositorio que gestionaa la persistencia de tareas y correos.
     */
	private IRepositorio repositorio;
    /**
     * Servicio utilizado para el envío de correos electrónicos.
     */
	private IMailerStub mailer;

    /**
     * Crea un servicio con un repositorio y un enviador de correos asociado.
     * @param repositorio El repositorio asociado.
     * @param mailerStub El enviador de correos asociado.
     */
    public Servicio(IRepositorio repositorio, IMailerStub mailerStub){
    	this.repositorio = repositorio;
    	this.mailer = mailerStub;
    }

    /**
     * Crea y almacena una nueva tarea con el nombre y la fecha límite indicados.
     * @param nombre El nombre de la tarea; no debe ser {@code null} ni vacío.
     * @param fechaLimite La fecha límite en milisegundos de la tarea; debe ser una fecha futura.
     * @return {@code true} si la tarea se ha añadido; {@code false} en caso contrario.
     */
    public boolean anadirTarea(String nombre, long fechaLimite){
    	ToDo tarea = new ToDo();
    	tarea.setNombre(nombre);
    	tarea.setFechaLimite(fechaLimite);
        boolean b = this.repositorio.almacenarTarea(tarea);
        this.verificarAlertas();
        return b;
    }

    /**
     * Añade una dirección de correo electrónico a la agenda.
     * @param dirCorreo La dirección de correo electrónico a añadir, no puede ser {@code null} ni la cadena vacía.
     * @return {@code true} si el correo se ha añadido; {@code false} si ya existía en la agenda.
     */
    public boolean anadirDireccion (String dirCorreo){
        boolean b = this.repositorio.almacenarEmail(dirCorreo);
        this.verificarAlertas();
        return b;
    }

    /**
     * Marca una tarea como completada
     * @param tarea La tarea a marcar; debe existir en el repositorio.
     * @return {@code true} si la tarea se ha marcado como completada; {@code false} en caso contrario.
     * @see IRepositorio#tareaCompletada(ToDo)
     */
    public boolean marcarCompletada (ToDo tarea){
        boolean b = this.repositorio.tareaCompletada(tarea);
        this.verificarAlertas();
        return b;
    }

    /**
     * Obtiene la lista de tareas pendientes.
     * @return La lista de tareas que no han sido completadas.
     */
    public List<ToDo> listarPendientes (){
    	List<ToDo> todas = repositorio.listarTodas();
        List<ToDo> pendientes = new ArrayList<>();

        for (ToDo t : todas) {
            if (!t.isCompletado()) {
                pendientes.add(t);
            }
        }

        this.verificarAlertas();
        return pendientes;
    }

    /**
     * Comprueba si existen tareas sin completar cuya fecha límite haya vencido
     * y envía un correo de alerta a cada dirección de la agenda.
     * <p>
     *     Este método se invoca automáticamente al final de cada operación pública.
     * </p>
     */
    private void verificarAlertas() {
    	long ahora = System.currentTimeMillis();
        List<ToDo> todas = this.repositorio.listarTodas();
        Set<String> listaCorreos = this.repositorio.obtenerAgenda();

        for (ToDo t : todas) {
            if (!t.isCompletado() && t.getFechaLimite() < ahora) {
                for(String direccion : listaCorreos) {
                	this.mailer.enviarCorreo(direccion, "La tarea "+t.getNombre()+" ha excedido su fecha límite y no está completada.");
                }
            }
        }
    }

}
