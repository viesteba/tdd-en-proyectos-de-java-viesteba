package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.tt1.test.mock.DBMock;

class RepositorioTest {
	ToDo tarea;
	DBMock db;
	IRepositorio repositorio;
	String email;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		tarea = new ToDo("CTAN","Buscar paquetes",System.currentTimeMillis()+1000,false);
		email = "lordOfTheStrings@domain.com";
		db = new DBMock();
		repositorio = new Repositorio(db);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAlmacenarTarea() {
		repositorio.almacenarTarea(tarea);
		assertTrue(db.bTareaCreada(), "Ha almacenado una tarea");
	}
	@Test
	void testAlmacenarEmail() {
		repositorio.almacenarEmail(email);
		assertTrue(db.bAgregarEmail(),"Ha almacenado un email");
	}
	@Test
	void testEncontrarTarea() {
		repositorio.almacenarTarea(tarea);
		repositorio.encontrarTarea(tarea);
		assertTrue(db.bTareaDevuelta(),"Ha buscado la tarea");
	}
	@Test
	void testTareaCompletada() {
		repositorio.almacenarTarea(tarea);
		repositorio.tareaCompletada(tarea);
		assertTrue(db.bActualizarTarea(),"Ha actualizado la tarea");
	}
	@Test
	void testListarTodas() {
		repositorio.almacenarTarea(tarea);
		repositorio.listarTodas();
		assertTrue(db.bListarTodas(),"Ha listado todas las tareas");
	}

}
