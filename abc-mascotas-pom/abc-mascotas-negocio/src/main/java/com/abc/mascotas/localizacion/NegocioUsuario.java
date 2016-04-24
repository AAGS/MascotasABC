package com.abc.mascotas.localizacion;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class NegocioUsuario {
	
	@PersistenceContext(unitName = "MascotasPU")
	private EntityManager em;
    
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Usuario encontrarUsuarioPorLogin(String login){
		TypedQuery<Dueno> typedQuery = em.createQuery("SELECT d FROM Dueno d WHERE d.login = :login ", Dueno.class);
		typedQuery.setParameter("login", login);
		List<Dueno> lista = typedQuery.getResultList();
		if (lista != null && !lista.isEmpty()){
			return lista.get(0);
		}else{
			return null;
		}
	}
}