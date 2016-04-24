package com.abc.mascotas.excepciones;

public class EncripcionNoValidaException extends GeneralException {

	private static final long serialVersionUID = 1L;

	public EncripcionNoValidaException(String mensaje) {
		super(mensaje);
	}

}