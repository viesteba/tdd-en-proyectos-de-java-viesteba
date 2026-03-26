package com.tt1.test;
/**
 * Emula el envío de correos electrónicos.
 * @implNote Esta clase es un stub diseñado exclusivamente para pruebas.
 * @author Víctor Esteban Chacobo
 * @version 1.0
 * @since 1.0
 * @see IMailerStub
 */
public class MailerStub implements IMailerStub{
    /**
     * Un contador de los correos que se han enviado.
     */
	private int correosEnviados = 0;

    /**
     * Envía un correo electrónico a partir de un correo y un mensaje. Escribe por consola ambas.
     * @param dirCorreo El correo electrónico al que enviar el mensaje, no puede ser {@code null} ni vacío.
     * @param mensaje El mensaje a enviar no puede ser {@code null} ni vacío.
     * @return Devuelve true si el mensaje y el correo no son nulos ni vacíos.
     */
    public boolean enviarCorreo (String dirCorreo, String mensaje){
    	if(dirCorreo==null || dirCorreo.equals("") || mensaje==null || mensaje.equals("")){
    			return false;
    	}
        System.out.println("Enviamos un correo a: "+dirCorreo);
        System.out.println("Enviamos el mensaje: "+mensaje);
        correosEnviados++;
        return true;
    }

    /**
     * Devuelve el número de correos enviados.
     * @return La cantidad de correos enviados.
     */
    public int getCorreosEnviados() {
        return correosEnviados;
    }

    /**
     * Limpia el número de correos enviados.
     */
    public void reset() {
        this.correosEnviados = 0;
    }
}
