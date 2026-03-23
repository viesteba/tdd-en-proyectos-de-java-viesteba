package com.tt1.test.mock;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.tt1.test.IDBStub;
import com.tt1.test.ToDo;

public class DBMock implements IDBStub{
	private boolean tareaCreada = false, tareaDevuelta = false, actualizarTarea=false, eliminarTarea = false, listarTodas = false, pedirAgenda = false, agregarEmail = false;

	@Override
	public ToDo crearTarea(ToDo nuevaTarea) {
		this.tareaCreada = true;
		return new ToDo("Dummy", "", 0, false);
	}

	@Override
	public ToDo devolverTarea(int id) {
		this.tareaDevuelta = true;
		return new ToDo("Dummy", "", 0, false);
	}

	@Override
	public ToDo actualizarTarea(ToDo tareaActualizada) {
		this.actualizarTarea = true;
		return new ToDo("Dummy", "", 0, false);
	}

	@Override
	public ToDo eliminarTarea(int id) {
		this.eliminarTarea = true;
		return new ToDo("Dummy", "", 0, false);
	}

	@Override
	public List<ToDo> listarTodas() {
		this.listarTodas = true;
		return new ArrayList<>();
	}

	@Override
	public Set<String> getAgenda() {
		this.pedirAgenda = true;
		Set<String> agenda = new HashSet<>();
		agenda.add("emailto@gmail.com");
;		return agenda;
	}

	@Override
	public boolean agregarEmail(String correo) {
		this.agregarEmail = true;
		return true;
	}
	public boolean bTareaCreada() {
		return this.tareaCreada;
	}
	public boolean bTareaDevuelta() {
		return this.tareaDevuelta;
	}
	public boolean bActualizarTarea() {
		return this.actualizarTarea;
	}
	public boolean bEliminarTarea() {
		return this.eliminarTarea;
	}
	public boolean bListarTodas() {
		return this.listarTodas;
	}
	public boolean bPedirAgenda() {
		return this.pedirAgenda;
	}
	public boolean bAgregarEmail() {
		return this.agregarEmail;
	}

}
