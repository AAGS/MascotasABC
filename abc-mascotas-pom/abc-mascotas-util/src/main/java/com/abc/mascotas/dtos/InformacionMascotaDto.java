package com.abc.mascotas.dtos;

import java.util.Calendar;

public class InformacionMascotaDto{

	private Long id;
	
	private double longitud;
	
	private double latitud;
	
	private Calendar fecha;

	private String lugar;
	
	private String ritmoCardiaco;
	
	private String frecuenciaRespiratoria;

	private Long idRuta;
	
	private String login;
	
	private String password;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdRuta() {
		return idRuta;
	}

	public void setIdRuta(Long id) {
		this.idRuta = id;
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

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getRitmoCardiaco() {
		return ritmoCardiaco;
	}

	public void setRitmoCardiaco(String ritmoCardiaco) {
		this.ritmoCardiaco = ritmoCardiaco;
	}

	public String getFrecuenciaRespiratoria() {
		return frecuenciaRespiratoria;
	}

	public void setFrecuenciaRespiratoria(String frecuenciaRespiratoria) {
		this.frecuenciaRespiratoria = frecuenciaRespiratoria;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "InformacionMascotaDto [id=" + id + ", longitud=" + longitud + ", latitud=" + latitud + ", fecha="
				+ fecha + ", lugar=" + lugar + ", ritmoCardiaco=" + ritmoCardiaco + ", frecuenciaRespiratoria="
				+ frecuenciaRespiratoria + ", idRuta=" + idRuta + "]";
	}
}
