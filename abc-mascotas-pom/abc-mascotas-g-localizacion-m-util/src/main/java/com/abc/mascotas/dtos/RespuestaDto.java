package com.abc.mascotas.dtos;

public class RespuestaDto{

	protected Integer codigoMensaje;
	protected String mensaje;
	protected String resultado;

	public Integer getCodigoMensaje() {
		return codigoMensaje;
	}
	public void setCodigoMensaje(Integer codigoMensaje) {
		this.codigoMensaje = codigoMensaje;
	}
	
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
}
