/**
 * 
 */
package com.clienteservidor.utilities;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

import com.clienteservidor.entities.User;

/**
 * Clase Utilidades para el tratamiento de datos de la BBDD.
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
	
	/**
     * Method to validate User attributes
     * 
     * @return
     */
    public static Map<String, String> validation(User u) {
    	
    	// Creación de hashmap con clave String del valor a comprobar, y el valor
        // ok o ko para true o false respectivamente.
        HashMap<String, String> userValidation = new HashMap<>();
        
        userValidation.put("Nombre de usuario: ", checkSize(u.getLogin(), 255));
        userValidation.put("Contraseña: ", checkSize(u.getPassword(), 255));
        userValidation.put("Nombre: ", allLetters(u.getName(), 255));
        userValidation.put("Apellidos: ", allLetters(u.getSurname(), 255));
        userValidation.put("Dirección: ", checkSize(u.getAddress(), 255));
        userValidation.put("Provincia: ", validateSelect(u.getState()));
        userValidation.put("Localidad: ", checkSize(u.getCity(), 255));
        userValidation.put("Código postal: ", validateCP(u.getPostalCode()));
        userValidation.put("Teléfono: ", validatePhone(u.getPhoneNumber()));
        //userValidation.put("Términos de uso: ", validateToS(u.getTos()));

        return userValidation;
    }

    public static String checkSize(String toValidate, int maxSize) {
    	String result = "Vacío o tiene más de " + maxSize + " caracteres.";
    	
    	if (toValidate.toCharArray().length <= maxSize && !toValidate.isBlank()) {
    		result = "ok";
    	}
    	
    	return result;
    }
    
    public static String allLetters(String toValidate, int maxSize) {
        String result = "Solo admite letras y no tener más de " + maxSize + " caracteres.";
        
        if (toValidate == null) {
            return result;
        } else if (toValidate.matches("[ 0-9A-Za-zñÑáéíóúÁÉÍÓÚ¡!¿?@#$%()=+-€/.,]{1,50}") && toValidate.toCharArray().length <= 255) {
            result = "ok";
        }

        return result;
    }

    public static String validateDNI (String toValidate) {
        final Pattern REGEXP = Pattern.compile("[0-9]{8}[A-Z]");
        final String DIGITO_CONTROL = "TRWAGMYFPDXBNJZSQVHLCKE";
        final String[] INVALIDOS = new String[] { "00000000T", "00000001R", "99999999R" };
        String result ="ko";
    
        if (toValidate == null) {
            return result;
        } else if (Arrays.binarySearch(INVALIDOS, toValidate) < 0 && REGEXP.matcher(toValidate).matches() && toValidate.charAt(8) == DIGITO_CONTROL.charAt(Integer.parseInt(toValidate.substring(0, 8)) % 23)) {
            result = "ok";
        }
        
        return result;
    }
    
    public static String validatePhone (String toValidate) {
        String result = "Está vacío o no se han puesto 9 dígitos.";
        
        if (toValidate == null) {
            return result;
        } else if (toValidate.matches("\\d{9}")) {
            result = "ok";
        }
        
        return result;
    }

    public static String validateSelect(String toValidate) {
        String result = "ok";

        if (toValidate.equalsIgnoreCase("0")) {
            result = "Escoja una provincia del desplegable.";
        }

        return result;
    }

    public static String validateCP(String toValidate) {
        String result = "Está vacío o no se han puesto 5 dígitos.";

        if (toValidate == null) {
            return result;
        } else if (toValidate.matches("\\d{5}")) {
            result = "ok";
        }

        return result;
    }

    public static String validateToS(String toValidate) {
        String result = "ko";

        if (toValidate == null) {
            return result;
        } else if (toValidate.equalsIgnoreCase("on")) {
            result = "ok";
        }

        return result;
    }
}