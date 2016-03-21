package com.abc.mascotas.localizacion;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.abc.mascotas.dtos.InformacionMascotaDto;
import com.abc.mascotas.dtos.RespuestaMascotaDto;

@Stateless
public class NegocioMascota {

	@PersistenceContext(unitName = "MascotasPU")
	private EntityManager em;
	
	@EJB
	private NegocioRuta negocioRuta;

	public Boolean guardar(InformacionMascotaDto informacionMascotaDto) {
		Boolean exito = false;
		Punto punto = new Punto();

		try {
			Ruta ruta = negocioRuta.obtenerRutaPorId(informacionMascotaDto.getIdRuta());

			if (ruta != null) {
				MappingDtoToPunto(informacionMascotaDto, punto, ruta);
				em.persist(punto);
				exito = true;
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}

		return exito;
	}

	private void MappingDtoToPunto(InformacionMascotaDto informacionMascotaDto, Punto punto, Ruta ruta) {
		punto.setLongitud(informacionMascotaDto.getLongitud());
		punto.setLatitud(informacionMascotaDto.getLatitud());
		punto.setFecha(informacionMascotaDto.getFecha());
		punto.setLugar(informacionMascotaDto.getLugar());
		punto.setRitmoCardiaco(informacionMascotaDto.getRitmoCardiaco());
		punto.setFrecuenciaRespiratoria(informacionMascotaDto.getFrecuenciaRespiratoria());
		punto.setRuta(ruta);
	}
	
	public RespuestaMascotaDto consultarPosicionActual(Long idRuta) {
		RespuestaMascotaDto resultadoMascotaDto = new RespuestaMascotaDto();
		resultadoMascotaDto.setCodigoMensaje(0);
		resultadoMascotaDto.setMensaje("OK");
		Ruta ruta = negocioRuta.obtenerRutaPorId(idRuta);
		if (ruta != null){
			TypedQuery<Punto> typedQuery = em.createQuery("SELECT p FROM Punto p WHERE p.ruta.id = :idRuta ORDER BY p.fecha DESC ", Punto.class);
			typedQuery.setParameter("idRuta", idRuta);
			List<Punto> punto = typedQuery.setMaxResults(1).getResultList();
			if (punto != null && !punto.isEmpty()){
				Punto p = punto.get(0);
				resultadoMascotaDto.setFechaUltimaPosicion(p.getFecha());
				resultadoMascotaDto.setLongitud(p.getLongitud());
				resultadoMascotaDto.setLatitud(p.getLatitud());
				resultadoMascotaDto.setNombreMascota(p.getRuta().getMascota().getNombre());
				resultadoMascotaDto.setIdRuta(p.getRuta().getId());
				resultadoMascotaDto.setNombreRuta(p.getRuta().getNombre());
			}else{
				resultadoMascotaDto.setCodigoMensaje(2);
				resultadoMascotaDto.setMensaje("No hay posicion para esta mascota");
			}
		}else{
			resultadoMascotaDto.setCodigoMensaje(1);
			resultadoMascotaDto.setMensaje("La ruta no existe en el sistema");
		}
		return resultadoMascotaDto;
	}
}
