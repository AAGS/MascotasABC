package com.abc.mascotas.localizacion;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.abc.mascotas.dtos.InformacionMascotaDto;

@Stateless
public class NegocioMascota {

	@PersistenceContext(unitName="MascotasPU")
	private EntityManager em;
	
	public void guardar(InformacionMascotaDto informacionMascotaDto){
		System.out.println("GUARDA");
	}
}
