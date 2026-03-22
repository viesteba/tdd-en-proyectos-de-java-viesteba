package com.tt1.test;

public class MailerStub implements IMailerStub{
	private int correosEnviados = 0;
    //Envío de un correo electrónico
    public boolean enviarCorreo (String dirCorreo, String mensaje){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    public int getCorreosEnviados() {
        return correosEnviados;
    }

    // Para limpiar entre tests
    public void reset() {
        this.correosEnviados = 0;
    }
}
