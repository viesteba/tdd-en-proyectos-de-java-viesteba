package com.tt1.test;

import java.util.List;
import java.util.Set;

public class Repositorio implements IRepositorio{
    //Comunicamos con DBStub
	private IDBStub db;
	
	public Repositorio(IDBStub db) {
	}
    public void tareaCompletada(ToDo tarea){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    public ToDo encontrarTarea (ToDo tarea){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    public void almacenarTarea (ToDo tarea){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    public void almacenarEmail (String correo){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    public List<ToDo> listarTodas(){
    	throw new UnsupportedOperationException("Clase aún no implementada.");
    }
}