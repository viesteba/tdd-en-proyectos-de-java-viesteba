package com.tt1.test;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class ToDo implements Serializable{
	// Propiedades privadas
    private String nombre;
    private String descripcion;
    private long fechaLimite;
    private boolean completado;
    private int id;

    // Constructor sin parámetros
    public ToDo(){
    	super();
    	this.nombre = null;
    	this.descripcion = null;
    	this.fechaLimite=0L;
    	this.completado = false;
    }
    public ToDo(String nombre, String descripcion, long fecha, boolean completado) {
    	this.nombre = nombre;
    	this.descripcion = descripcion;
    	this.fechaLimite = fecha;
    	this.completado = completado;
    }
    
    // Métodos getters y setters
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return this.nombre;
    }
    public void setDescripcion (String descripcion){
        this.descripcion = descripcion;
    }
    public String getDescripcion(){
        return this.descripcion;
    }
    public void setFechaLimite (long fecha){
        this.fechaLimite = fecha;
    }
    public long getFechaLimite(){
        return this.fechaLimite;
    }
    public void setCompletado (boolean completado){
        this.completado = completado;
    }
    public boolean isCompletado(){
        return this.completado;
    }
    public void setId(int identificador){
        this.id = identificador;
    }
    public int getId(){
        return this.id;
    }
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
    @Override
    public int hashCode() {
        // Genera un número único basado en el contenido de los campos
        return Objects.hash(nombre, descripcion, fechaLimite, completado, id);
    }
}
