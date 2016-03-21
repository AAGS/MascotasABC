package com.abc.mascotas.localizacion.servicios;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.abc.mascotas.dtos.InformacionMascotaDto;
import com.abc.mascotas.dtos.RespuestaDto;
import com.abc.mascotas.localizacion.NegocioMascota;

@Path(value="Mascota")
public class ServicioMascota {

	@EJB
	private NegocioMascota negocioMascota;
	
	@POST
	@Path("guardar")
	@Consumes("application/json")
	@Produces("application/json")	
	public RespuestaDto guardarInformacion(InformacionMascotaDto informacionMascotaDto){
		Boolean res = negocioMascota.guardar(informacionMascotaDto);
		RespuestaDto respuesta = new RespuestaDto();
		if(res)
		{
			respuesta.setResultado("Ok");
			respuesta.setMensaje("Información registrada con exito");		
		}
		return respuesta;
	}
}
