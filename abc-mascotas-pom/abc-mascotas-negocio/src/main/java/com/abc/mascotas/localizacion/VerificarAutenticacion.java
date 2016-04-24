package com.abc.mascotas.localizacion;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import org.apache.log4j.Logger;

import com.abc.mascotas.dtos.InformacionMascotaDto;
import com.abc.mascotas.dtos.RespuestaMascotaDto;
import com.abc.mascotas.enums.UsuarioAutenticado;
import com.abc.mascotas.excepciones.EncripcionNoValidaException;
import com.abc.mascotas.util.Utilidades;


@Stateless
public class VerificarAutenticacion{

	private static final Logger LOG = Logger.getLogger(VerificarAutenticacion.class);
	
	@EJB
	private NegocioUsuario negocioUsuario;
	
	@AroundInvoke
	public Object validarUsuario(InvocationContext ctx) throws Exception{
		Object[] parametros = ctx.getParameters();
		InformacionMascotaDto parametro = (InformacionMascotaDto) parametros[0];
		RespuestaMascotaDto respuestaMascotaDto = new RespuestaMascotaDto();
		if (parametro != null && parametro.getLogin() != null && parametro.getPassword() != null){
			Usuario usuario = negocioUsuario.encontrarUsuarioPorLogin(parametro.getLogin());
		    if (usuario != null){
		    	try{
			    	return validarContrasena(respuestaMascotaDto, ctx, usuario.getPassword(), parametro.getPassword());
		    	}catch(EncripcionNoValidaException e){
		    		respuestaMascotaDto.setMensaje(e.getMensaje());
		    		LOG.error(e.getMensaje());
		    	}
		    }else{
		    	respuestaMascotaDto.setMensaje("El usuario no existe en el sistema");
		    }	
		}else{
			respuestaMascotaDto.setMensaje("Faltan credenciales de autenticacion del usuario");
	    }
		return respuestaMascotaDto;
	}
	
	private Object validarContrasena(RespuestaMascotaDto respuestaMascotaDto,InvocationContext ctx, String pwdBD, String pwdParametro) throws Exception{
		UsuarioAutenticado usuarioAutenticado = Utilidades.verificarPwd(pwdBD, pwdParametro);
		if (usuarioAutenticado.equals(UsuarioAutenticado.SI)){
			return ctx.proceed();
		}else{
			 respuestaMascotaDto.setMensaje("La contraseña es inválida");
		}
		return respuestaMascotaDto;
	}
}