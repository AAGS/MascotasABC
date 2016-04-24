package com.abc.mascotas.excepciones;

public abstract class GeneralException extends Exception {

	private static final long serialVersionUID = 1L;

	protected String mensaje;
	
	public GeneralException(String mensaje){
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}	
}