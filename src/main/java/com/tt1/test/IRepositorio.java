package com.tt1.test;

import java.util.List;

public interface IRepositorio {
	public void tareaCompletada(ToDo tarea);
	public ToDo encontrarTarea (ToDo tarea);
	public void almacenarTarea (ToDo tarea);
	public void almacenarEmail (String correo);
	public List<ToDo> listarTodas();
}
