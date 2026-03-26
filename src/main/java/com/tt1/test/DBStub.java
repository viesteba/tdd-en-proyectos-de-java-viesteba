package com.tt1.test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * Emula una base de datos
 * <p>
 *  Contiene información sobre las tareas y la agenda de emails.
 * </p>
 * @implNote Esta clase es un stub diseñado exclusivamente para pruebas.
 * @author Víctor Esteban Chacobo
 * @version 1.0
 * @since 1.0
 * @see IDBStub
 */
public class DBStub implements IDBStub{
    /**
     * Un mapa de tareas donde la clave es autoincremental.
     */
    private Map<Integer,ToDo> tareas;
    /**
     * Una pequeña agenda de emails de gente a contactar.
     */
    private Set<String> agenda;
    /**
     * Un contador autoincremental para identificar las tareas.
     */
    private int contadorId = 1;

    /**
     * Crea una base de datos.
     */
    public DBStub() {
    	tareas = new HashMap<>();
    	agenda = new HashSet<String>();
    }

    /**
     * Añade una tarea la base de datos.
     * @param nuevaTarea La tarea a agregar.
     * @return La tarea que ocupaba ese identificador previamente, o {@code null} si no había ninguna.
     */
    public ToDo crearTarea(ToDo nuevaTarea){
        ToDo tarea = this.tareas.put(contadorId, nuevaTarea);
        nuevaTarea.setId(this.contadorId);
        this.contadorId++;
        return tarea;
    }

    /**
     * Devuelve una tarea en base a su posición en el mapa.
     * @param id El identificador en el mapa de tareas.
     * @return La tarea asignada al identificador id y {@code null} si no existe.
     */
    public ToDo devolverTarea(int id){
    	return this.tareas.get(id);
    }

    /**
     * Actualiza una tarea.
     * @param tareaActualizada La tarea con los datos actualizados; su {@code id} debe existir en la base de datos.
     * @return La versión anterior de la tarea, o {@code null} si el identificador no existía.
     */
    public ToDo actualizarTarea(ToDo tareaActualizada){
        return this.tareas.put(tareaActualizada.getId(), tareaActualizada);
    }

    /**
     * Elimina una tarea en base a su identificador.
     * @param id El identificador de una tarea a eliminar.
     * @return La tarea eliminada, o {@code null} si no existía ninguna con ese identificador.
     */
    public ToDo eliminarTarea(int id){
    	ToDo tarea = this.tareas.get(id);
    	if(tarea!=null) {
    		this.tareas.remove(id);
    		tarea.setId(0);
    	}
    	return tarea;
    }

    /**
     * Lista todas las tareas de la base de datos.
     * @return Una lista con todas las tareas en la base de datos.
     */
    public List<ToDo> listarTodas(){
        return new ArrayList<>(this.tareas.values());
    }

    /**
     * Obtiene la agenda de la base de datos.
     * @return Una agenda con todos los correos almacenados en la base de datos.
     */
    public Set<String> getAgenda(){
    	return this.agenda;
    }

    /**
     * Añade un email a la base de datos.
     * @param email Un correo electrónico.
     * @return {@code true} si se ha agregado el email y {@code false} en caso contrario.
     */
    public boolean agregarEmail(String email){
        return agenda.add(email);
    }
}
