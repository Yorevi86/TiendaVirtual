/**
 * 
 */
package com.clienteservidor.utilities;

/**
 * Clase Utilidades para el tratamiento de datos recibidos de la BBDD.
 * 
 * @author Jonatan
 *
 */
public class Utilidades {

	// Contructor
	private Utilidades() {
		
		throw new IllegalStateException("Clase para utilidades únicamente.");
	}
	
	/**
	 * Método para convertir un int a boolean, 1 = true, 0 = false.
	 * 
	 * @param check
	 * @return boolean
	 */
	public static boolean convertIntToBoolean (int check) {
		
		String validation = String.valueOf(check);
		
		return validation.equalsIgnoreCase("1");
	}
	
	/**
	 * Método para conertir un boolean a int para la BBDD, true = 1, false = 0.
	 * 
	 * @param check
	 * @return
	 */
	public static int convertBooleanToInt (boolean check) {
		
		return check? 1: 0;
	}
}