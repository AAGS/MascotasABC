package com.abc.mascotas.localizacion;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


@Stateless
@LocalBean
public class PruebaEJB {

	@PersistenceContext(unitName="MascotasPU")
	private EntityManager em;
	
	public List<Mascota> getMascotas(){
		TypedQuery<Mascota> mascotas = em.createQuery("SELECT m FROM Mascota m ", Mascota.class);
		return mascotas.getResultList();
	}
}
