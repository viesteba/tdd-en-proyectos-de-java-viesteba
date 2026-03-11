package com.tt1.test;

import java.util.List;

public class Servicio {
	private Repositorio repositorio;
	private MailerStub mailer;
	
    public Servicio(Repositorio repositorio, MailerStub mailerStub){
    	
    }
    public boolean anadirTarea(String nombre, long fechaLimite){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    public boolean anadirDireccion (String dirCorreo){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    public boolean marcarCompletada (ToDo tarea){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    public List<ToDo> listarPendientes (){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    private void verificarAlertas() {
    	throw new UnsupportedOperationException("Clase aún no implementada.");
    }

}
