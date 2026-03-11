package com.tt1.test;

import java.util.List;

public interface IDBStub {
	public ToDo crearTarea(ToDo nuevaTarea);
	public ToDo devolverTarea(int id);
	public ToDo actualizarTarea(ToDo tareaActualizada);
	public ToDo eliminarTarea(int id);
	public List<ToDo> listarTodas();
}
