package com.tt1.test.mock;

import java.util.ArrayList;
import java.util.List;

import com.tt1.test.IRepositorio;
import com.tt1.test.ToDo;

public class RepositorioMock implements IRepositorio{
	private boolean tareaCompletada = false, tareaEncontrada = false, tareaAlmacenada = false, 
			emailAlmacenado = false, listarTodas = false;
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

	@Override
	public List<ToDo> listarTodas() {
		this.listarTodas = true;
		return new ArrayList<>();
	}
	public boolean bTareaCompletada() {
		return this.tareaCompletada;
	}
	public boolean bTareaEncontraada() {
		return this.tareaEncontrada;
	}
	public boolean bTareaAlmacenada() {
		return this.tareaAlmacenada;
	}
	public boolean bEmailAlmacenado() {
		return this.emailAlmacenado;
	}
}
