package com.abc.mascotas.localizacion;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "MASCOTA")
public class Mascota {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;

	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="FECHANACIMIENTO")
	@Temporal(TemporalType.DATE)
	private Calendar fechaNacimiento;
	
	@ManyToOne
	@JoinColumn(name="ID_DUENO")
	private Dueno dueno;
	
	@OneToMany(mappedBy="mascota")
	private List<Ruta> rutas;
	
	@ManyToOne
	@JoinColumn(name="ID_TIPO_ANIMAL")
	private TipoAnimal tipoAnimal;
	
	@ManyToOne
	@JoinColumn(name="ID_TIPO_RAZA")
	private TipoRaza tipoRaza;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Calendar getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Calendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Dueno getDueno() {
		return dueno;
	}

	public void setDueno(Dueno dueno) {
		this.dueno = dueno;
	}

	public List<Ruta> getRutas() {
		return rutas;
	}

	public void setRutas(List<Ruta> rutas) {
		this.rutas = rutas;
	}

	public TipoAnimal getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(TipoAnimal tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

	public TipoRaza getTipoRaza() {
		return tipoRaza;
	}

	public void setTipoRaza(TipoRaza tipoRaza) {
		this.tipoRaza = tipoRaza;
	}
}
