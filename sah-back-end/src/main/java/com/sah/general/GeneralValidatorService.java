package com.sah.general;

public class GeneralValidatorService {
	public boolean validarStringSinEspacios(String string, String mensaje) {
		if(string.replace(" ", "") == string) {
			return true;
		} else {
			throw new RuntimeException(mensaje);
		}
	}
}
