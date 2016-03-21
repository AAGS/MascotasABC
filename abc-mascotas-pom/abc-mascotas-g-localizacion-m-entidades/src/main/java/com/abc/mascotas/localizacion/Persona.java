package com.abc.mascotas.localizacion;

import javax.persistence.*;

@Entity
@Table(name= "PERSONA")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO_PERSONA")
public abstract class Persona {

	@Id
	@Column(name="ID")
	private Long id;
	
	@Column(name="TIPO_IDENTIFICACION")
	@Enumerated(EnumType.ORDINAL)
	private TipoIdentificacionEnum tipoIdentificacion;
	
	@Column(name="NUMERO_IDENTIFICACION")
	private String numeroIdentificacion;
	
	@Column(name="NOMBRES")
	private String nombres;
	
	@Column(name="APELLIDOS")
	private String apellidos;
	
	@Column(name="TELEFONO")
	private String telefono;
	
	@Column(name="CELULAR")
	private String celular;
	
	@Column(name="DIRECCION")
	private String direccion;
	
	@Column(name="EMAIL")
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoIdentificacionEnum getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(TipoIdentificacionEnum tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
