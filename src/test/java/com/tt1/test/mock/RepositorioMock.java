package com.tt1.test.mock;

import java.util.ArrayList;
import java.util.List;

import com.tt1.test.IDBStub;
import com.tt1.test.IRepositorio;
import com.tt1.test.ToDo;

public class RepositorioMock implements IRepositorio{
	private boolean tareaCompletada = false, tareaEncontrada = false, tareaAlmacenada = false, 
			emailAlmacenado = false, listarTodas = false;
	// Lista interna para que el test pueda "inyectar" tareas de prueba
    private List<ToDo> tareasSimuladas = new ArrayList<>();
    
    public RepositorioMock(IDBStub db) {
    	
    }
    
	@Override
	public void tareaCompletada(ToDo tarea) {
		this.tareaCompletada = true;
	}

	@Override
	public ToDo encontrarTarea(ToDo tarea) {
		this.tareaEncontrada = true;
		return new ToDo("Dummy", "", 0, false);
	}

	@Override
	public void almacenarTarea(ToDo tarea) {
		this.tareaAlmacenada = true;
		
	}

	@Override
	public void almacenarEmail(String correo) {
		this.emailAlmacenado = true;
	}
	// Método extra para el Test: permite configurar qué devolverá el mock
    public void simularTareas(List<ToDo> tareas) {
        this.tareasSimuladas = tareas;
    }

	@Override
	public List<ToDo> listarTodas() {
		this.listarTodas = true;
		return new ArrayList<>();
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
