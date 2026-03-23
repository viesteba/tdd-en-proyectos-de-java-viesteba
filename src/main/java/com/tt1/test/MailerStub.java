package com.tt1.test;

public class MailerStub implements IMailerStub{
	private int correosEnviados = 0;
    //Envío de un correo electrónico
    public boolean enviarCorreo (String dirCorreo, String mensaje){
    	if(dirCorreo==null || dirCorreo.equals("") || mensaje==null || mensaje.equals("")){
    			return false;
    	}
        System.out.println("Enviamos un correo a: "+dirCorreo);
        System.out.println("Enviamos el mensaje: "+mensaje);
        correosEnviados++;
        return true;
    }
    public int getCorreosEnviados() {
        return correosEnviados;
    }

    // Para limpiar entre tests
    public void reset() {
        this.correosEnviados = 0;
    }
}
