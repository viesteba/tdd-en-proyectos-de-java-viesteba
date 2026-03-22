package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RepositorioTest {
	ToDo tarea;
	DBStub db;
	Repositorio repositorio;
	String email;

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	public void setUp() throws Exception {
		tarea = new ToDo("CTAN","Buscar paquetes",System.currentTimeMillis()+1000,false);
		email = "lordOfTheStrings@domain.com";
		db = new DBStub();
		repositorio = new Repositorio(db);
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testTareaCompletada() {
		repositorio.almacenarTarea(tarea);
		repositorio.tareaCompletada(tarea);
		assertTrue(repositorio.encontrarTarea(tarea).isCompletado());
	}
	@Test
	public void testEncontrarTarea() {
		repositorio.almacenarTarea(tarea);
		assertEquals(tarea,repositorio.encontrarTarea(tarea));
		repositorio.tareaCompletada(tarea);
		assertTrue(repositorio.encontrarTarea(tarea).isCompletado());
	}
	@Test
	public void testAlmacenarTarea() {
		repositorio.almacenarTarea(tarea);
		assertEquals(1,repositorio.listarTodas().size());
	}
	@Test
	public void testAlmacenarEmail() {
		repositorio.almacenarEmail(email);
		assertTrue(db.getAgenda().contains(email),"El email está en la agenda");
		assertEquals(1, db.getAgenda().size(),"La agenda tiene exactamente 1 email");
		repositorio.almacenarEmail(email);
		assertEquals(1, db.getAgenda().size(),"La agenda tiene exactamente 1 email");
	}
	@Test
	public void testListarTodas() {
		// 1. Añadimos la tarea creada en el setUp()
		repositorio.almacenarTarea(tarea);
		
		// 2. Creamos y almacenamos una segunda tarea
		ToDo tarea2 = new ToDo("TEX", "Compilar documento LaTeX", System.currentTimeMillis() + 2000, false);
		repositorio.almacenarTarea(tarea2);
		
		// 3. Recuperamos la lista
		List<ToDo> todas = repositorio.listarTodas();
		
		// 4. Comprobamos que funciona como esperamos
		assertNotNull(todas, "La lista devuelta no debería ser nula");
		assertEquals(2, todas.size(), "Debería haber exactamente 2 tareas almacenadas");
		assertTrue(todas.contains(tarea), "La lista debe contener la primera tarea");
		assertTrue(todas.contains(tarea2), "La lista debe contener la segunda tarea");
	}

}
