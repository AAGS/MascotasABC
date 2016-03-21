package com.abc.mascotas.localizacion;

import java.util.List;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="DUENO")
public class Dueno extends Usuario{

	@OneToMany(mappedBy="dueno")
	private List<Mascota> mascotas;

	public List<Mascota> getMascotas() {
		return mascotas;
	}

	public void setMascotas(List<Mascota> mascotas) {
		this.mascotas = mascotas;
	}
}
