package com.tt1.test.mock;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.tt1.test.IDBStub;
import com.tt1.test.IRepositorio;
import com.tt1.test.ToDo;

public class RepositorioMock implements IRepositorio{
	private boolean tareaCompletada = false, tareaEncontrada = false, tareaAlmacenada = false, 
			emailAlmacenado = false, listarTodas = false;
	// Lista interna para que el test pueda "inyectar" tareas de prueba
    private List<ToDo> tareasSimuladas;
    private IDBStub db;
    
    public RepositorioMock(IDBStub db) {
    	this.tareasSimuladas = new ArrayList<>();
    	this.db = db;
    }
    
	@Override
	public boolean tareaCompletada(ToDo tarea) {
		this.tareaCompletada = true;
		return true;
	}

	@Override
	public ToDo encontrarTarea(ToDo tarea) {
		this.tareaEncontrada = true;
		return new ToDo("Dummy", "", 0, false);
	}

	@Override
	public boolean almacenarTarea(ToDo tarea) {
		this.tareaAlmacenada = true;
		return true;
		
	}

	@Override
	public boolean almacenarEmail(String correo) {
		this.emailAlmacenado = true;
		return true;
	}
	// Método extra para el Test: permite configurar qué devolverá el mock
    public void simularTareas(List<ToDo> tareas) {
        this.tareasSimuladas = tareas;
    }
    public Set<String> obtenerAgenda(){
    	return this.db.getAgenda();
    }

	@Override
	public List<ToDo> listarTodas() {
		this.listarTodas = true;
		return this.tareasSimuladas;
	}
	public boolean bTareaCompletada() {
		return this.tareaCompletada;
	}
	public boolean bTareaEncontrada() {
		return this.tareaEncontrada;
	}
	public boolean bTareaAlmacenada() {
		return this.tareaAlmacenada;
	}
	public boolean bEmailAlmacenado() {
		return this.emailAlmacenado;
	}
	public boolean bListarTodas() {
		return this.listarTodas;
	}
}
