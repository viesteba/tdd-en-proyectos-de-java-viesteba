package com.tt1.test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DBStub implements IDBStub{
    private Map<Integer,ToDo> tareas; //autogenerar id autoincremental
    private Set<String> agenda;
    private int contadorId = 1;
    //El email ya es clave primaria
    public DBStub() {
    	tareas = new HashMap<>();
    	agenda = new HashSet<String>();
    }
    public ToDo crearTarea(ToDo nuevaTarea){
        this.tareas.put(contadorId, nuevaTarea);
        nuevaTarea.setId(this.contadorId);
        this.contadorId++;
        return nuevaTarea;
    }
    public ToDo devolverTarea(int id){
    	return this.tareas.get(id);
    }
    public ToDo actualizarTarea(ToDo tareaActualizada){
        return this.tareas.put(tareaActualizada.getId(), tareaActualizada);
    }
    public ToDo eliminarTarea(int id){
    	ToDo tarea = this.tareas.get(id);
    	if(tarea!=null) {
    		this.tareas.remove(id);
    		tarea.setId(0);
    	}
    	return tarea;
    }
    public List<ToDo> listarTodas(){
        return new ArrayList<>(this.tareas.values());
    }
    public Set<String> getAgenda(){
    	return this.agenda;
    }
    public boolean agregarEmail(String email){
        return agenda.add(email);
    }
}
