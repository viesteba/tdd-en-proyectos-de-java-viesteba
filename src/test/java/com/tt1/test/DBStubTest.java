package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DBStubTest {
	
	DBStub db;
	ToDo tarea;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		tarea = new ToDo("CTAN","Buscar paquetes",System.currentTimeMillis()+1000,false);
		db = new DBStub();
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCrearTarea() {
		db.crearTarea(tarea);
		assertEquals(1,db.listarTodas().size());
	}
	@Test
	void testDevolverTarea() {
		db.crearTarea(tarea);
		ToDo tareaDevuelta = db.devolverTarea(1);
		assertEquals(tareaDevuelta,tarea);
	}
	@Test
	void testActualizarTarea() {
		db.crearTarea(tarea);
		tarea.setDescripcion("Actualizar latexmk");
		db.actualizarTarea(tarea);
		assertEquals(db.devolverTarea(1),tarea);
	}
	@Test
	void testEliminarTarea() {
		db.crearTarea(tarea);
		db.eliminarTarea(1);
		assertNull(db.devolverTarea(1));
	}
	@Test
	void testAgregarEmail() {
		// Probamos que se añada correctamente
		db.agregarEmail("lordOfTheStrings@domain.com");
		assertTrue(db.getAgenda().contains("lordOfTheStrings@domain.com"), "El email debería estar en la agenda");
		assertEquals(1, db.getAgenda().size(), "La agenda debería tener exactamente 1 email");
		
		// Probamos que no se dupliquen (al ser un Set, no debería)
		db.agregarEmail("lordOfTheStrings@domain.com");
		assertEquals(1, db.getAgenda().size(), "La agenda no debe duplicar emails idénticos");
	}
	@Test
	void testListarTodas() {
		// Creamos un par de tareas para comprobar que la lista crece adecuadamente
		db.crearTarea(tarea); // Tarea del setUp()
		ToDo tarea2 = new ToDo("TEX", "Actualizar librerías", System.currentTimeMillis(), false);
		db.crearTarea(tarea2);
		
		List<ToDo> todas = db.listarTodas();
		
		assertNotNull(todas, "La lista no debe ser nula");
		assertEquals(2, todas.size(), "Debería haber 2 tareas en la lista");
	}

}
