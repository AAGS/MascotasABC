package com.abc.mascotas.localizacion;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.abc.mascotas.dtos.InformacionMascotaDto;

@Stateless
public class NegocioMascota {

	@PersistenceContext(unitName = "MascotasPU")
	private EntityManager em;
	
	@EJB
	private NegocioRuta nr;

	public Boolean guardar(InformacionMascotaDto informacionMascotaDto) {
		Boolean exito = false;
		Punto punto = new Punto();

		try {
			Ruta ruta = nr.obtenerRutaPorId(informacionMascotaDto.getIdRuta());

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
}
