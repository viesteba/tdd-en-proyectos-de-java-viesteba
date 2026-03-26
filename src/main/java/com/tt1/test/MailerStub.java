package com.tt1.test;
/**
 * Emula el envío de correos electrónicos.
 * <p>
 *     Simula el envío imprimiendo por consola el destinatario y el mensaje,
 *     e incrementa un contador interno de correos enviados.
 * </p>
 * @implNote Esta clase es un stub diseñado exclusivamente para pruebas.
 * No realiza ningún envío real de correos.
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
     * Simula el envío de un correo electrónico a partir de un correo y un mensaje imprimiendo por consola el destinatario y el mensaje.
     * <p>
     *     Si el correo es exitoso, incrementa el contador interno de correos enviados.
     * </p>
     * @param dirCorreo El correo electrónico destinatorio.
     * @param mensaje El mensaje a enviar.
     * @return Devuelve {@code true} si el mensaje y el correo no son {@code null} ni vacíos y el correo se ha simulado;
     * {@code false} en otro caso.
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
     * Obtiene el número de correos enviados desde la creación o último {@link #reset()}.
     * @return La cantidad de correos enviados; {@code 0} si no se ha enviado ninguno o tras un reset.
     */
    public int getCorreosEnviados() {
        return correosEnviados;
    }

    /**
     * Reinicia el contador de correos enviados a cero.
     * <p>
     *     Útil entre pruebas para garantizar un estado limpio.
     * </p>
     * @see #getCorreosEnviados()
     */
    public void reset() {
        this.correosEnviados = 0;
    }
}
