package com.tt1.test;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Representa una tarea (To-Do)
 * <p>
 *  Contiene información sobre el nombre, descripción, fecha límite y estado de completitud.
 *  Implementa {@link java.io.Serializable} para permitir su persistencia.
 *  </p>
 * @author Víctor Esteban Chacobo
 * @version 1.0
 * @since 1.0
 */
public class ToDo implements Serializable{
	// Propiedades privadas
    /**
     * Nombre de la tarea
     */
    private String nombre;
    /**
     * Descripción de la tarea
     */
    private String descripcion;
    /**
     * Fecha límite de la tarea
     */
    private long fechaLimite;
    /**
     * Representa si la tarea se ha completado
     */
    private boolean completado;
    /**
     * Identificador de la tarea
     */
    private int id;

    /**
     * Crea una tarea
     */
    public ToDo(){
    	super();
    	this.nombre = null;
    	this.descripcion = null;
    	this.fechaLimite=0L;
    	this.completado = false;
    }
    /**
     * Crea una tarea con el nombre, la descripción, la fecha límite y el estado especificados
     * @param nombre El nombre de la tarea
     * @param descripcion La descripción de la tarea
     * @param fecha La fecha límite en que vence la tarea
     * @param completado El estado actual de la tarea
     */
    public ToDo(String nombre, String descripcion, long fecha, boolean completado) {
    	this.nombre = nombre;
    	this.descripcion = descripcion;
    	this.fechaLimite = fecha;
    	this.completado = completado;
    }

    /**
     * Establece el nombre de la tarea.
     * @param nombre El nombre de la tarea
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    /**
     * Obtiene el nombre de la tarea.
     * @return Una cadena indicando el nombre de la tarea
     */
    public String getNombre(){
        return this.nombre;
    }
    /**
     * Establece la descripción de la tarea.
     * @param descripcion La descripción de la tarea
     */
    public void setDescripcion (String descripcion){
        this.descripcion = descripcion;
    }
    /**
     * Obtiene la descripción de la tarea.
     * @return Una cadena indicando la descripción de la tarea
     */
    public String getDescripcion(){
        return this.descripcion;
    }
    /**
     * Establece la fecha límite de la tarea.
     * @param fecha La fecha límite de la tarea
     */
    public void setFechaLimite (long fecha){
        this.fechaLimite = fecha;
    }
    /**
     * Obtiene la fecha límite de la tarea.
     * @return Un {@code long} indicando la fecha límite en milisegundos
     */
    public long getFechaLimite(){
        return this.fechaLimite;
    }
    /**
     * Establece el estado de la tarea.
     * @param completado El estado de la tarea
     */
    public void setCompletado (boolean completado){
        this.completado = completado;
    }
    /**
     * Obtiene el estado de completitud de la tarea.
     * @return {@code true} si la  tarea está completa; {@code false} en caso contrario
     */
    public boolean isCompletado(){
        return this.completado;
    }
    /**
     * Establece el identificador de la tarea.
     * @param identificador El identificador de la tarea
     */
    public void setId(int identificador){
        this.id = identificador;
    }
    /**
     * Obtiene el identificador de completitud de la tarea.
     * @return El identificador de la tarea
     */
    public int getId(){
        return this.id;
    }
    /**
     * Compara dos tareas.
     * @return {@code true} si ambas tareas tienen los mismos campos; {@code false} en caso contrario
     */
    @Override
    public boolean equals(Object o) {
    	if(this==o) {
    		return true;
    	}
    	if(o==null || this.getClass()!= o.getClass()) {
    		return false;
    	}
    	ToDo tarea1 = (ToDo) o;
    	return this.id==tarea1.id &&
    			this.completado == tarea1.completado &&
    			this.fechaLimite == tarea1.fechaLimite &&
    			this.nombre.equals(tarea1.nombre) &&
    			this.descripcion.equals(tarea1.descripcion);

    }
    /**
     * Genera un código hash basado en todos los campos de la tarea.
     * @return El código hash de esta instancia
     */
    @Override
    public int hashCode() {
        // Genera un número único basado en el contenido de los campos
        return Objects.hash(nombre, descripcion, fechaLimite, completado, id);
    }
}
