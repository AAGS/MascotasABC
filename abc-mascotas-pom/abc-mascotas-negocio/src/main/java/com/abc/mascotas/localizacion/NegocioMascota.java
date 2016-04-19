package com.abc.mascotas.localizacion;

import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.abc.mascotas.dtos.InformacionMascotaDto;
import com.abc.mascotas.dtos.RespuestaMascotaDto;
import com.abc.mascotas.util.Utilidades;

@Stateless
public class NegocioMascota {

	private static final Logger LOG = Logger.getLogger(NegocioMascota.class);
	private static final String GUARDAR = "guardar";

	@PersistenceContext(unitName = "MascotasPU")
	private EntityManager em;

	@EJB
	private NegocioRuta negocioRuta;

	@EJB
	private NegocioLog negocioLog;

	public Boolean guardar(InformacionMascotaDto informacionMascotaDto) {
		Boolean exito = false;
		Boolean validacion = true;
		Punto punto = new Punto();
		LogPeticionesFallidas logPeticionesFallidas = null;

		try {
			Ruta ruta = negocioRuta.obtenerRutaPorId(informacionMascotaDto.getIdRuta());
			String mensaje = "";
			if (ruta == null) {
				mensaje = "Ruta no valida";
				validacion = false;
			} else if (!Utilidades.esValidoLongitud(informacionMascotaDto.getLongitud())) {
				mensaje = "Longitud no valida";
				validacion = false;
			} else if (!Utilidades.esValidoLatitud(informacionMascotaDto.getLatitud())) {
				mensaje = "Latitud no valida";
				validacion = false;
			} else if (!Utilidades.esCorrectoRitmoCardiaco(informacionMascotaDto.getRitmoCardiaco())) {
				mensaje = "Ritmo Cardiaco no valido";
				validacion = false;
			} else if (!Utilidades.esCorrectoFrecuenciaRespiratoria(informacionMascotaDto.getFrecuenciaRespiratoria())) {
				mensaje = "Frecuencia Respiratoria no valida";
				validacion = false;
			}

			if (!validacion) {
				logPeticionesFallidas = construirObjetoLog(GUARDAR, informacionMascotaDto.toString(), mensaje);
				negocioLog.guardar(logPeticionesFallidas);
			} else {
				mappingDtoToPunto(informacionMascotaDto, punto, ruta);
				em.persist(punto);
				exito = true;
			}
		} catch (Exception e) {
			logPeticionesFallidas = construirObjetoLog("guardar", informacionMascotaDto.toString(),
					"Error excepcion " + e.getMessage());
			negocioLog.guardar(logPeticionesFallidas);
			LOG.log(Level.ERROR, "Error " + e.getMessage(), e);
		}

		return exito;
	}

	private void mappingDtoToPunto(InformacionMascotaDto informacionMascotaDto, Punto punto, Ruta ruta) {
		punto.setLongitud(informacionMascotaDto.getLongitud());
		punto.setLatitud(informacionMascotaDto.getLatitud());
		punto.setFecha(Calendar.getInstance());
		punto.setLugar(informacionMascotaDto.getLugar());
		punto.setRitmoCardiaco(informacionMascotaDto.getRitmoCardiaco());
		punto.setFrecuenciaRespiratoria(informacionMascotaDto.getFrecuenciaRespiratoria());
		punto.setRuta(ruta);
	}

	public RespuestaMascotaDto consultarPosicionActual(Long idRuta) {
		LogPeticionesFallidas logPeticionesFallidas;
		RespuestaMascotaDto resultadoMascotaDto = new RespuestaMascotaDto();
		resultadoMascotaDto.setCodigoMensaje(0);
		resultadoMascotaDto.setMensaje("OK");
		Ruta ruta = negocioRuta.obtenerRutaPorId(idRuta);
		if (ruta != null) {
			TypedQuery<Punto> typedQuery = em
					.createQuery("SELECT p FROM Punto p WHERE p.ruta.id = :idRuta ORDER BY p.fecha DESC ", Punto.class);
			typedQuery.setParameter("idRuta", idRuta);
			List<Punto> punto = typedQuery.setMaxResults(1).getResultList();
			if (punto != null && !punto.isEmpty()) {
				Punto p = punto.get(0);
				resultadoMascotaDto.setFechaUltimaPosicion(p.getFecha());
				resultadoMascotaDto.setLongitud(p.getLongitud());
				resultadoMascotaDto.setLatitud(p.getLatitud());
				resultadoMascotaDto.setNombreMascota(p.getRuta().getMascota().getNombre());
				resultadoMascotaDto.setIdRuta(p.getRuta().getId());
				resultadoMascotaDto.setNombreRuta(p.getRuta().getNombre());
				resultadoMascotaDto.setIdPosicion(p.getId());
			} else {
				logPeticionesFallidas = construirObjetoLog("consultarPosicionActual", idRuta.toString(),
						"No hay posiscion para esta mascota");
				negocioLog.guardar(logPeticionesFallidas);
				resultadoMascotaDto.setCodigoMensaje(2);
				resultadoMascotaDto.setMensaje("No hay posicion para esta mascota");
			}
		} else {
			logPeticionesFallidas = construirObjetoLog("consultarPosicionActual", idRuta.toString(),
					"La ruta no existe en el sistema");
			negocioLog.guardar(logPeticionesFallidas);
			resultadoMascotaDto.setCodigoMensaje(1);
			resultadoMascotaDto.setMensaje("La ruta no existe en el sistema");
		}
		return resultadoMascotaDto;
	}

	private static LogPeticionesFallidas construirObjetoLog(String metodo, String parametros, String mensaje) {
		LogPeticionesFallidas logPeticionesFallidas = new LogPeticionesFallidas();
		logPeticionesFallidas.setMetodo(metodo);
		logPeticionesFallidas.setFecha(Calendar.getInstance());
		logPeticionesFallidas.setMensaje(mensaje);
		logPeticionesFallidas.setParametros(parametros);
		return logPeticionesFallidas;
	}
}