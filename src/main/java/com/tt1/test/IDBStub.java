package com.tt1.test;

import java.util.List;
import java.util.Set;

public interface IDBStub {
	public ToDo crearTarea(ToDo nuevaTarea);
	public ToDo devolverTarea(int id);
	public ToDo actualizarTarea(ToDo tareaActualizada);
	public ToDo eliminarTarea(int id);
	public List<ToDo> listarTodas();
	public Set<String> getAgenda();
	public boolean agregarEmail(String email);
}
