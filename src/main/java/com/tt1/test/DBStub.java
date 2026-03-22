package com.tt1.test;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DBStub implements IDBStub{
    private Map<Integer,ToDo> tareas; //autogenerar id autoincremental
    private Set<String> agenda;
    private int contadorId = 1;
    //El email ya es clave primaria
    public ToDo crearTarea(ToDo nuevaTarea){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    public ToDo devolverTarea(int id){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    public ToDo actualizarTarea(ToDo tareaActualizada){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    public ToDo eliminarTarea(int id){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    public List<ToDo> listarTodas(){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    public Set<String> getAgenda(){
    	throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    public boolean agregarEmail(String email){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
}
