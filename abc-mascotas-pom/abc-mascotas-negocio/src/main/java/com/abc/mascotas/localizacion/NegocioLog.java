package com.abc.mascotas.localizacion;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class NegocioLog {
	
	@PersistenceContext(unitName = "MascotasPU")
	private EntityManager em;
    
	@Asynchronous
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void guardar(LogPeticionesFallidas log){
		em.merge(log);
	}
}
