package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ToDoTest {
	private ToDo tarea;
	private long fechaReferencia;

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	public void setUp() throws Exception {
		tarea = new ToDo();
		fechaReferencia = System.currentTimeMillis();
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testToDoConstructorVacio() {
		assertNull("El nombre debería ser null por defecto", tarea.getNombre());
		assertNull(tarea.getDescripcion());
		assertEquals(0L, tarea.getFechaLimite());
		assertFalse(tarea.isCompletado());
	}

	@Test
	public void testToDoConstructorConParametros() {
		ToDo tareaLlena = new ToDo("Limpiar la ducha","En el baño del piso",fechaReferencia,true);
		assertEquals("Limpiar la ducha",tareaLlena.getNombre());
		assertEquals(fechaReferencia,tareaLlena.getFechaLimite());
		assertEquals("En el baño del piso",tareaLlena.getDescripcion());
		assertTrue(tarea.isCompletado());
	}

	@Test
	public void testSetYGetNombre() {
		tarea.setNombre("Actualizar CV");
		assertEquals("Actualizar CV", tarea.getNombre());
	}
	@Test
	public void testSetNombreVacio() {
		tarea.setNombre("");
		assertEquals("", tarea.getNombre());
	}
	
	@Test
	public void testSetYGetDescripcion() {
		tarea.setDescripcion("En Eclipse-workspace");
		assertEquals("En Eclipse-workspace", tarea.getDescripcion());
	}
	@Test
	public void testSetDescripcionVacio() {
		tarea.setDescripcion("");
		assertEquals("", tarea.getDescripcion());
	}

	@Test
	public void testSetYGetFechaLimite() {
		tarea.setFechaLimite(fechaReferencia);
		assertEquals(fechaReferencia, tarea.getFechaLimite());
	}
	@Test
	public void testSetFechaLimiteCero() {
		tarea.setFechaLimite(0L);
		assertEquals(0L, tarea.getFechaLimite());
	}

	@Test
	public void testIsCompletado() {
		tarea.setCompletado(true);
		assertTrue(tarea.isCompletado());
	}

}
