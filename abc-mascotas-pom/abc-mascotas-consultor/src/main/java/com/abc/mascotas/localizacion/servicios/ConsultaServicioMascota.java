package com.abc.mascotas.localizacion.servicios;


import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.abc.mascotas.dtos.InformacionMascotaDto;
import com.abc.mascotas.dtos.RespuestaMascotaDto;
import com.abc.mascotas.localizacion.NegocioMascota;

@Path(value="ConsultaMascota")
public class ConsultaServicioMascota {

	@EJB
	private NegocioMascota negocioMascota;
	
	@POST
	@Path("posicionActual")
	@Consumes("application/json")	
	@Produces("application/json")	
	public RespuestaMascotaDto consultarPosicionActual(InformacionMascotaDto informacionMascotaDto){
		return negocioMascota.consultarPosicionActual(informacionMascotaDto);
	}
}
