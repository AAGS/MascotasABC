package com.abc.mascotas.excepciones;

public class UsuarioInvalidoExcepcion extends GeneralException {

	private static final long serialVersionUID = 1L;

	public UsuarioInvalidoExcepcion(String mensaje) {
		super(mensaje);
	}

}