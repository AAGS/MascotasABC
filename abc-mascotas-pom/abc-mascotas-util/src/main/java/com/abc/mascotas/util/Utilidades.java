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

	private Utilidades() {
	}

	public static boolean esValidoLongitud(double longitud) {
		return longitud >= LONGITUD_MIN && longitud <= LONGITUD_MAX;
	}

	public static boolean esValidoLatitud(double latitud) {
		return latitud >= LATITUD_MIN && latitud <= LATITUD_MAX;
	}

	public static boolean esCorrectoRitmoCardiaco(String ritmoCardiaco) {
		try {
			double ritmo = Double.parseDouble(ritmoCardiaco);
			return ritmo >= RITMO_CARDIACO_MIN && ritmo <= RITMO_CARDIACO_MAX;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	public static boolean esCorrectoFrecuenciaRespiratoria(String frecuenciaRespiratoria) {
		try {
			double frecuencia = Double.parseDouble(frecuenciaRespiratoria);
			return frecuencia > FRECUENCIA_RESPIRATORIA_MIN && frecuencia <= FRECUENCIA_RESPIRATORIA_MIN;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}
}