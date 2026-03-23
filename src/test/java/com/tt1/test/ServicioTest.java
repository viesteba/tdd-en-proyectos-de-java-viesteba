package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.tt1.test.mock.DBMock;
import com.tt1.test.mock.MailerMock;
import com.tt1.test.mock.RepositorioMock;

class ServicioTest {
	ToDo tarea;
	DBMock db;
	RepositorioMock repo;
	MailerMock mailer;
	Servicio serv;
	long tiempo;
	String email;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		tiempo = System.currentTimeMillis()+1000;
		tarea = new ToDo("CTAN","Buscar paquetes",tiempo,false);
		db = new DBMock();
		repo = new RepositorioMock(db);
		mailer = new MailerMock();
		serv = new Servicio(repo,mailer);
		mailer.reset();
		email = "lordOfTheStrings@domain.com";
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAnadirTarea() {
		serv.anadirTarea("Hoy", System.currentTimeMillis());
		assertTrue(repo.bTareaAlmacenada(),"Ha almacenado la tarea");
	}
	@Test
	void testAnadirDireccion() {
		serv.anadirDireccion(email);
		assertTrue(repo.bEmailAlmacenado(),"Ha almacenado el correo");
	}
	@Test
	void testMarcarCompletada() {
		serv.marcarCompletada(tarea);
		assertTrue(repo.bTareaEncontrada(), "Ha encontrado la tarea");
		assertTrue(repo.bTareaCompletada(),"Ha completado la tarea");
	}
	@Test
	void testListarPendientes() {
		serv.anadirTarea("Hoy", System.currentTimeMillis());
		serv.listarPendientes();
		assertTrue(repo.bListarTodas());
	}
	@Test
	void testAlertas() {
		List<ToDo> listaConCaducada = new ArrayList<>();
	    listaConCaducada.add(new ToDo("Caducada", "Test", System.currentTimeMillis() - 10000, false));
	    repo.simularTareas(listaConCaducada);
	    
	    serv.listarPendientes();
	    assertTrue(mailer.bEnviarCorreo(), "El servicio debería haber enviado el correo de alerta");
	}

}
