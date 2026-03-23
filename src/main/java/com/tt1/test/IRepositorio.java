package com.tt1.test;

import java.util.List;
import java.util.Set;

public interface IRepositorio {
	public boolean tareaCompletada(ToDo tarea);
	public ToDo encontrarTarea (ToDo tarea);
	public boolean almacenarTarea (ToDo tarea);
	public boolean almacenarEmail (String correo);
	public List<ToDo> listarTodas();
	public Set<String> obtenerAgenda();
}
