package com.tt1.test;

import java.util.List;
import java.util.Set;
/**
 * Define el contrato de acceso a datos del sistema de tareas.
 * <p>
 * Declara las operaciones disponibles sobre las tareas y la agenda
 * de correos electrónicos. Las implementaciones de esta interfaz
 * son responsables de gestionar la persistencia de los datos.
 * </p>
 * @author Víctor Esteban Chacobo
 * @version 1.0
 * @since 1.0
 * @see DBStub
 * @see ToDo
 */
public interface IDBStub {
    /**
     * Añade una nueva tarea al sistema y le asigna un identificador único.
     * @param nuevaTarea La tarea a agregar; no debe ser {@code null}.
     * @return La tarea que ocupaba ese identificador previamente,
     *         o {@code null} si no había ninguna (caso habitual).
     */
	public ToDo crearTarea(ToDo nuevaTarea);
    /**
     * Obtiene una tarea a partir de su identificador.
     * @param id El identificador de la tarea a buscar.
     * @return La tarea con ese identificador, o {@code null} si no existe.
     */
	public ToDo devolverTarea(int id);
    /**
     * Actualiza una tarea.
     * @param tareaActualizada La tarea con los datos actualizados; su {@code id} debe existir en la base de datos.
     * @return La versión anterior de la tarea, o {@code null} si el identificador no existía.
     */
	public ToDo actualizarTarea(ToDo tareaActualizada);
    /**
     * Elimina una tarea en base a su identificador.
     * @param id El identificador de una tarea a eliminar.
     * @return La tarea eliminada, o {@code null} si no existía ninguna con ese identificador.
     */
	public ToDo eliminarTarea(int id);
    /**
     * Lista todas las tareas almacenadas.
     * @return Lista con todas las tareas.
     */
	public List<ToDo> listarTodas();
    /**
     * Obtiene el conjunto de correos electrónicos de la agenda.
     * @return Conjutno de todos los correos almacenados.
     */
	public Set<String> getAgenda();
    /**
     * Añade un email a la agenda.
     * @param email Un correo electrónico a añadir; no debe ser {@code null}.
     * @return {@code true} si se ha agregado el email y {@code false} en caso contrario.
     */
	public boolean agregarEmail(String email);
}
