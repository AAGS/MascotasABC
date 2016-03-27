package com.abc.mascotas.dtos;

import java.util.List;

public class DuenoDto{

	private List<MascotaDto> mascotas;

	public List<MascotaDto> getMascotas() {
		return mascotas;
	}

	public void setMascotas(List<MascotaDto> mascotas) {
		this.mascotas = mascotas;
	}
}
