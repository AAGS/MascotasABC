package com.abc.mascotas.localizacion;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PUNTO")
public class Punto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="LONGITUD")
	private double longitud;
	
	@Column(name="LATITUD")
	private double latitud;
	
	@Column(name="FECHA")
	@Temporal(TemporalType.DATE)
	private Calendar fecha;

	@Column(name = "LUGAR")
	private String lugar;
	
	@Column(name = "RITMOCARDIACO")
	private String ritmoCardiaco;
	
	@Column(name = "FRECUENCIARESPIRATORIA")
	private String frecuenciaRespiratoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
}
