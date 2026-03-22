package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ServicioTest {
	ToDo tarea;
	DBStub db;
	Repositorio repo;
	MailerStub mailer;
	Servicio serv;
	long tiempo;

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	public void setUp() throws Exception {
		tiempo = System.currentTimeMillis()+1000;
		tarea = new ToDo("CTAN","Buscar paquetes",tiempo,false);
		db = new DBStub();
		repo = new Repositorio(db);
		mailer = new MailerStub();
		serv = new Servicio(repo,mailer);
		mailer.reset();
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testServicio() {
		
		
		
	}

	@Test
	public void testAnadirTarea() {
		serv.anadirTarea("CTAN",tiempo);
		assertEquals(serv.listarPendientes().size(),1, "Hay una tarea pendiente");
	}

	@Test
	public void testAnadirDireccion() {
		serv.anadirDireccion("lordOfStrings@domain.com");
		assertEquals(db.getAgenda().size(), 1, "Hay un correo en la agenda");
	}

	@Test
	public void testMarcarCompletada() {
		serv.anadirTarea("CTAN", tiempo);
	    // Recuperamos la tarea que acaba de guardar el servicio
	    ToDo tareaGuardada = serv.listarPendientes().get(0); 
	    
	    serv.marcarCompletada(tareaGuardada);
	    assertEquals(0, serv.listarPendientes().size(), "La tarea se ha completado");
	}
	@Test
	public void testAlertaPorTareaCaducada() {
	    // 1. Preparamos el escenario
	    serv.anadirDireccion("usuario1@test.com");
	    serv.anadirDireccion("usuario2@test.com"); // Dos correos en la agenda
	    
	    // Tarea que ya venció hace 10 minutos
	    long haceDiezMinutos = System.currentTimeMillis() - 600000;
	    
	    // 2. Ejecutamos la acción que dispara la alerta
	    serv.anadirTarea("Comprar leche", haceDiezMinutos);
	    
	    // 3. Verificación automática
	    // Si hay 1 tarea caducada y 2 personas en la agenda, se deben haber enviado 2 correos
	    assertEquals(2, mailer.getCorreosEnviados(), 
	        "Deberían haberse enviado 2 alertas (una por cada email en la agenda)");
	}

}
