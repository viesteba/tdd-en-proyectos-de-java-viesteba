package com.tt1.test;

import java.util.List;
import java.util.Set;
/**
 * Define el contrato entre el repositorio y la base de datos.
 * @author Víctor Esteban Chacobo
 * @version 1.0
 * @since 1.0
 * @see Repositorio
 * @see IDBStub
 * @see ToDo
 */
public interface IRepositorio {
    /**
     * Marca una tarea como completada y persiste el cambio.
     * @param tarea La tarea a marcar como completada; debe existir en el repositorio.
     * @return {@code true} si la tarea se ha actualizado; {@code false} en caso contrario.
     */
	public boolean tareaCompletada(ToDo tarea);
    /**
     * Busca una tarea en el repositorio según su identificador.
     * @param tarea La tarea cuyo identificador se emplea para la búsqueda.
     * @return La tarea encontrada, o {@code null} si no existe ninguna con ese identificador.
     */
	public ToDo encontrarTarea (ToDo tarea);
    /**
     * Almacena una tarea en el repositorio y le asigna un identificador único.
     * @param tarea La tarea a almacenar; no debe ser {@code null}.
     * @return {@code true} si se ha guardado correctamente; {@code false} en caso contrario.
     */
	public boolean almacenarTarea (ToDo tarea);
    /**
     * Almacena un correo en el repositorio.
     * @param correo El correo electrónico a almacenar.
     * @return {@code true} si se ha guardado y {@code false} si ya existía en la agenda.
     */
	public boolean almacenarEmail (String correo);
    /**
     * Lista todas las tareas del repositorio; vacío si no hay ninguna.
     * @return Lista con todas las tareas almacenadas.
     */
	public List<ToDo> listarTodas();
    /**
     * Lista todos los correos agregados; vacío si no hay ninguno.
     * @return Conjunto de todos los correos en la agenda.
     */
	public Set<String> obtenerAgenda();
}
