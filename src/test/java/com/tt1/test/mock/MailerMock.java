package com.tt1.test.mock;

import com.tt1.test.IMailerStub;

public class MailerMock implements IMailerStub{
	private boolean correoEnviado = false, getCorreosEnviados = false, getReset = false;
	@Override
	public boolean enviarCorreo(String dirCorreo, String mensaje) {
		correoEnviado = true;
		return true;
	}

	@Override
	public int getCorreosEnviados() {
		this.getCorreosEnviados = true;
		return 0;
	}

	@Override
	public void reset() {
		this.getReset = true;
	}
	public boolean bEnviarCorreo() {
		return this.correoEnviado;
	}
	public boolean bGetCorreosEnviados() {
		return this.getCorreosEnviados;
	}
	public boolean bGetReset() {
		return this.getReset;
	}

}
