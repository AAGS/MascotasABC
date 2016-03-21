package com.abc.mascotas.dtos;

import java.util.Calendar;

public class RespuestaMascotaDto extends RespuestaDto{
	private String nombreMascota;
	private Calendar fechaUltimaPosicion;
	private double longitud;
	private double latitud;
	private Long idRuta;
	private String nombreRuta;
	
	public String getNombreMascota() {
		return nombreMascota;
	}
	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}
	public Calendar getFechaUltimaPosicion() {
		return fechaUltimaPosicion;
	}
	public void setFechaUltimaPosicion(Calendar fechaUltimaPosicion) {
		this.fechaUltimaPosicion = fechaUltimaPosicion;
	}
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	public double getLatitud() {
		return latitud;
	}
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	public Long getIdRuta() {
		return idRuta;
	}
	public void setIdRuta(Long idRuta) {
		this.idRuta = idRuta;
	}
	public String getNombreRuta() {
		return nombreRuta;
	}
	public void setNombreRuta(String nombreRuta) {
		this.nombreRuta = nombreRuta;
	}
}
