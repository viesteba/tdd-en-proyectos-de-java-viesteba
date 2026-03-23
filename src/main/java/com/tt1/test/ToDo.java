package com.tt1.test;

import java.io.Serializable;
import java.util.Date;

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
    	throw new UnsupportedOperationException("Clase aún no implementada.");
    }
}
