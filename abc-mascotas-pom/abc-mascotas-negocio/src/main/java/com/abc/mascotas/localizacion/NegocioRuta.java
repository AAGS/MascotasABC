package com.abc.mascotas.localizacion;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class NegocioRuta {

	@PersistenceContext(unitName="MascotasPU")
	private EntityManager em;
	
	public Ruta obtenerRutaPorId(Long idRuta){
		TypedQuery<Ruta> typedQuery = em.createQuery("SELECT r FROM Ruta r WHERE r.id = :idRuta ",Ruta.class);
		typedQuery.setParameter("idRuta", idRuta);
		List<Ruta> rutas = typedQuery.getResultList();
		if (rutas != null && !rutas.isEmpty()){
			return rutas.get(0);	
		}else{
			return null;
		}
	}
}