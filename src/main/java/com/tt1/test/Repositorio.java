package com.tt1.test;

import java.util.List;
import java.util.Set;

public class Repositorio implements IRepositorio{
    //Comunicamos con DBStub
	private IDBStub db;
	
	public Repositorio(IDBStub db) {
		this.db = db;
	}
    public boolean tareaCompletada(ToDo tarea){
    	tarea.setCompletado(true);
        return tarea == this.db.actualizarTarea(tarea);
    }
    public ToDo encontrarTarea (ToDo tarea){
        return this.db.devolverTarea(tarea.getId());
    }
    public boolean almacenarTarea (ToDo tarea){
        return tarea == this.db.crearTarea(tarea);
    }
    public boolean almacenarEmail (String correo){
        return this.db.agregarEmail(correo);
    }
    public List<ToDo> listarTodas(){
    	return this.db.listarTodas();
    }
    public Set<String> obtenerAgenda() {
        return this.db.getAgenda();
    }
}