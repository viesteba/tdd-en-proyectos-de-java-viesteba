package com.tt1.test;
/**
 * Define el contrato para enviar correos electrónicos.
 * <p>
 * Las implementaciones de esta interfaz son responsables de simular
 * o realizar el envío de correos, llevar la cuenta de los enviados
 * y permitir reiniciar dicho contador entre pruebas.
 * </p>
 * @author Víctor Esteban Chacobo
 * @version 1.0
 * @since 1.0
 * @see IMailerStub
 */
public interface IMailerStub {
    /**
     * Envía o simula el envío de un correo electrónico a partir de un correo y un mensaje.
     * @param dirCorreo El correo electrónico destinatorio.
     * @param mensaje El mensaje a enviar.
     * @return {@code true} si el mensaje y el correo no son {@code null} ni vacíos y el correo se ha simulado;
     * {@code false} en otro caso.
     */
	public boolean enviarCorreo (String dirCorreo, String mensaje);
    /**
     * Obtiene el número de correos enviados desde la creación o último {@link #reset()}.
     * @return La cantidad de correos enviados; {@code 0} si no se ha enviado ninguno o tras un reset.
     */
	public int getCorreosEnviados();
    /**
     * Reinicia el contador de correos enviados a cero.
     * <p>
     *     Útil entre pruebas para garantizar un estado limpio.
     * </p>
     * @see #getCorreosEnviados()
     * @see MailerStub#reset()
     */
	public void reset();
}
