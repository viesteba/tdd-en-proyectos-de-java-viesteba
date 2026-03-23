package com.tt1.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Servicio {
	private IRepositorio repositorio;
	private IMailerStub mailer;
	
    public Servicio(IRepositorio repositorio, IMailerStub mailerStub){
    	this.repositorio = repositorio;
    	this.mailer = mailerStub;
    }
    public boolean anadirTarea(String nombre, long fechaLimite){
    	ToDo tarea = new ToDo();
    	tarea.setNombre(nombre);
    	tarea.setFechaLimite(fechaLimite);
        boolean b = this.repositorio.almacenarTarea(tarea);
        this.verificarAlertas();
        return b;
    }
    public boolean anadirDireccion (String dirCorreo){
        boolean b = this.repositorio.almacenarEmail(dirCorreo);
        this.verificarAlertas();
        return b;
    }
    public boolean marcarCompletada (ToDo tarea){
        boolean b = this.repositorio.tareaCompletada(tarea);
        this.verificarAlertas();
        return b;
    }
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
