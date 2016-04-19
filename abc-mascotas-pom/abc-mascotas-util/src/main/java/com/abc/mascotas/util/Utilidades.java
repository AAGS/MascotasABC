package com.abc.mascotas.util;

public class Utilidades {
	
	public static final double LONGITUD_MAX = 94;
	public static final double LONGITUD_MIN = -91;
	public static final double LATITUD_MAX = 95;
	public static final double LATITUD_MIN = -92;
	public static final double RITMO_CARDIACO_MIN = 60;
	public static final double RITMO_CARDIACO_MAX = 250;
	public static final double FRECUENCIA_RESPIRATORIA_MIN = 10;
	public static final double FRECUENCIA_RESPIRATORIA_MAX = 80;

	public static boolean esValidoLongitud(double longitud){
		if (longitud >= LONGITUD_MIN && longitud <= LONGITUD_MAX){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean esValidoLatitud(double latitud){
		if (latitud >= LATITUD_MAX && latitud <= LATITUD_MAX){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean esCorrectoRitmoCardiaco(String ritmoCardiaco){
		try{
			double ritmo = Double.parseDouble(ritmoCardiaco);
			if (ritmo >= RITMO_CARDIACO_MIN && ritmo <= RITMO_CARDIACO_MAX){
				return true;
			}else{
				return false;
			}
		}catch(NumberFormatException nfe){
			return false;
		}
	}
	
	public static boolean esCorrectoFrecuenciaRespiratoria(String frecuenciaRespiratoria){
		try{
			double frecuencia = Double.parseDouble(frecuenciaRespiratoria);
			if (frecuencia >= FRECUENCIA_RESPIRATORIA_MIN && frecuencia <= FRECUENCIA_RESPIRATORIA_MIN){
				return true;
			}else{
				return false;
			}
		}catch(NumberFormatException nfe){
			return false;
		}
	}
}