package com.tt1.test;

import java.util.List;
import java.util.Set;
/**
 * Implementa la capa de acceso a datos del sistema.
 * <p>
 *     Permite encontrar tareas, marcarlas como completadas,
 *     y almacenar nuevas tareas y correos electrónicos en el stub de la base de datos.
 * </p>
 * @implNote Esta clase delega todas las operaciones en {@link IDBStub},
 *  por lo que su comportamiento depende de la implementación inyectada.
 * @author Víctor Esteban Chacobo
 * @version 1.0
 * @since 1.0
 * @see IRepositorio
 * @see IDBStub
 * @see ToDo
 */
public class Repositorio implements IRepositorio{
    /**
     * La base de datos con la que se comunica.
     */
	private IDBStub db;

    /**
     * Crea un repositorio con una base de datos asociada.
     * @param db La base de datos asociada al repositorio.
     */
	public Repositorio(IDBStub db) {
		this.db = db;
	}

    /**
     * Marca una tarea como completada y la actualiza en la base de datos.
     * @param tarea La tarea a marcar como completada; debe existir en la base de datos.
     * @return {@code true} si la tarea se ha actualizado; {@code false} en caso contrario.
     */
    public boolean tareaCompletada(ToDo tarea){
    	tarea.setCompletado(true);
        return tarea == this.db.actualizarTarea(tarea);
    }

    /**
     * Busca una tarea en la base de datos según su identificador.
     * @param tarea La tarea cuyo identificador se emplea para la búsqueda.
     * @return La tarea encontrada, o {@code null} si no existe ninguna con ese identificador.
     */
    public ToDo encontrarTarea (ToDo tarea){
        return this.db.devolverTarea(tarea.getId());
    }

    /**
     * Almacena una tarea en la base de datos y le asigna un identificador.
     * @param tarea La tarea a almacenar; no debe ser {@code null}.
     * @return {@code true} si se ha guardado correctamiente; {@code false} en caso contrario.
     */
    public boolean almacenarTarea (ToDo tarea){
        return tarea == this.db.crearTarea(tarea);
    }

    /**
     * Almacena un correo en el repositorio
     * @param correo El correo electrónico a almacenar.
     * @return {@code true} si se ha guardado y {@code false} en caso contrario.
     */
    public boolean almacenarEmail (String correo){
        return this.db.agregarEmail(correo);
    }

    /**
     * Lista todas las tareas del repositorio.
     * @return Lista con todas las tareas almacenadas.
     */
    public List<ToDo> listarTodas(){
    	return this.db.listarTodas();
    }

    /**
     * Lista todos los correos agregados.
     * @return Conjunto de todos los correos en la agenda.
     */
    public Set<String> obtenerAgenda() {
        return this.db.getAgenda();
    }
}