package com.abc.mascotas.localizacion.servicios;


import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.abc.mascotas.dtos.RespuestaMascotaDto;
import com.abc.mascotas.localizacion.NegocioMascota;

@Path(value="ConsultaMascota")
public class ConsultaServicioMascota {

	@EJB
	private NegocioMascota negocioMascota;
	
	@GET
	@Path("posicionActual/{idRuta}")
	@Produces("application/json")	
	public RespuestaMascotaDto guardarInformacion(@PathParam(value="idRuta") Long idRuta){
		return negocioMascota.consultarPosicionActual(idRuta);
	}
}
