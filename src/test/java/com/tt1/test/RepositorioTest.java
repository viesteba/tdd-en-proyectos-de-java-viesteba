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
	IDBStub db;
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
	void test() {
		fail("Not yet implemented");
	}

}
