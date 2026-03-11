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
    	throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    
    // Métodos getters y setters
    public void setNombre(String nombre){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    public String getNombre(){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    public void setDescripcion (String descripcion){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    public String getDescripcion(){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    public void setFechaLimite (long fecha){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    public long getFechaLimite(){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    public void setCompletado (boolean completado){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    public boolean isCompletado(){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    public void setId(String nombre){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    public String getId(){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
}
