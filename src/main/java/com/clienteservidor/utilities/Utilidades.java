/**
 * 
 */
package com.clienteservidor.utilities;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.clienteservidor.entities.Order;
import com.clienteservidor.entities.Product;
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
	public static boolean convertIntToBoolean(int check) {

		String validation = String.valueOf(check);

		return validation.equalsIgnoreCase("1");
	}

	/**
	 * Método para convertir un boolean a int para la BBDD, true = 1, false = 0.
	 * 
	 * @param check
	 * @return
	 */
	public static int convertBooleanToInt(boolean check) {

		return check ? 1 : 0;
	}

	/**
	 * Método para validar los atributos de un User.
	 * 
	 * @param User
	 * @return Map<String, String>
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
		// userValidation.put("Términos de uso: ", validateToS(u.getTos()));

		return userValidation;
	}
	
	/**
	 * Método para validar un cambio de dirección.
	 * 
	 * @param User
	 * @return Map<String, String>
	 */
	public static Map<String, String> addressValidation(User u) {

		// Creación de hashmap con clave String del valor a comprobar, y el valor
		// ok o ko para true o false respectivamente.
		HashMap<String, String> userValidation = new HashMap<>();

		userValidation.put("Dirección: ", checkSize(u.getAddress(), 255));
		userValidation.put("Provincia: ", validateSelect(u.getState()));
		userValidation.put("Localidad: ", checkSize(u.getCity(), 255));
		userValidation.put("Código postal: ", validateCP(u.getPostalCode()));

		return userValidation;
	}

	/**
	 * Método para validar que el texto no tiene más de una cantidad de caracteres.
	 * 
	 * @param toValidate
	 * @param maxSize
	 * @return String
	 */
	public static String checkSize(String toValidate, int maxSize) {
		String result = "Vacío o tiene más de " + maxSize + " caracteres.<br>";

		if (toValidate.toCharArray().length <= maxSize && !toValidate.isBlank()) {
			result = "ok";
		}

		return result;
	}

	/**
	 * Método para validar que solo se introducen letras y no más de una cantidad.
	 * 
	 * @param toValidate
	 * @param maxSize
	 * @return String
	 */
	public static String allLetters(String toValidate, int maxSize) {
		String result = "Solo admite letras y no tener más de " + maxSize + " caracteres.<br>";

		if (toValidate == null) {
			return result;
		} else if (toValidate.matches("[ 0-9A-Za-zñÑáéíóúÁÉÍÓÚ¡!¿?@#$%()=+-€/.,]{1,50}")
				&& toValidate.toCharArray().length <= 255) {
			result = "ok";
		}

		return result;
	}

	/**
	 * Método para validar el DNI por si se metiera en un futuro.
	 * 
	 * @param toValidate
	 * @return String
	 */
	public static String validateDNI(String toValidate) {
		final Pattern REGEXP = Pattern.compile("[0-9]{8}[A-Z]");
		final String DIGITO_CONTROL = "TRWAGMYFPDXBNJZSQVHLCKE";
		final String[] INVALIDOS = new String[] { "00000000T", "00000001R", "99999999R" };
		String result = "ko";

		if (toValidate == null) {
			return result;
		} else if (Arrays.binarySearch(INVALIDOS, toValidate) < 0 && REGEXP.matcher(toValidate).matches()
				&& toValidate.charAt(8) == DIGITO_CONTROL.charAt(Integer.parseInt(toValidate.substring(0, 8)) % 23)) {
			result = "ok";
		}

		return result;
	}

	/**
	 * Metodo para validar que el teléfono son 9 dígitos.
	 * 
	 * @param toValidate
	 * @return String
	 */
	public static String validatePhone(String toValidate) {
		String result = "Está vacío o no se han puesto 9 dígitos.<br>";

		if (toValidate == null) {
			return result;
		} else if (toValidate.matches("\\d{9}")) {
			result = "ok";
		}

		return result;
	}

	/**
	 * Metodo para validar que en el select de provincia, no se ha dejado el default.
	 * 
	 * @param toValidate
	 * @return String
	 */
	public static String validateSelect(String toValidate) {
		String result = "ok";

		if (toValidate.equalsIgnoreCase("0")) {
			result = "Escoja una provincia del desplegable.<br>";
		}

		return result;
	}

	/**
	 * Método para validar que el código postal tiene 5 números.
	 * 
	 * @param toValidate
	 * @return String
	 */
	public static String validateCP(String toValidate) {
		String result = "Está vacío o no se han puesto 5 dígitos.<br>";

		if (toValidate == null) {
			return result;
		} else if (toValidate.matches("\\d{5}")) {
			result = "ok";
		}

		return result;
	}

	/**
	 * Método para validar el marcado del ToS.
	 * 
	 * @param toValidate
	 * @return String
	 */
	public static String validateToS(String toValidate) {
		String result = "ko";

		if (toValidate == null) {
			return result;
		} else if (toValidate.equalsIgnoreCase("on")) {
			result = "ok";
		}

		return result;
	}

	/**
	 * Método para la contrucción de la tabla en la vista tienda.
	 * 
	 * @param listaProductos
	 * @return String
	 */
	public static StringBuilder convertirListaProductosATabla(List<Product> listaProductos) {

		// Se usa StringBuilder para elaboración dinámica del html
		// de forma rápida y eficaz.
		StringBuilder tabla = new StringBuilder();

		for (int i = 0; i < listaProductos.size(); i++) {

			Product producto = listaProductos.get(i);

			// Primer filtro para inicio de pintado de fila de tabla
			if (i % 4 == 0) {
				tabla.append("<tr>");
			}

			// Segundo filtro para rellenar con los distintos colores
			// según si es par o impar.
			if (i % 2 == 0) {
				tabla.append("<td class=\"tg-0lax\">");
			} else {
				tabla.append("<td class=\"tg-dg7a\">");
			}
			
			tabla.append(producto.getProductName());
			tabla.append("<br>");
			tabla.append(producto.getDescription());
			tabla.append("<br>");
			tabla.append(producto.getPrice());
			tabla.append("Euros<br><br>Seleccione cuantos quiere (max 10):<br>");
			// Usamos el método crearSelectDeProductos() para añadirle el stock
			// en un desplegable de selects.
			tabla.append(crearSelectDeProductos(producto.getStock(), producto.getProductID()));

			// Tercer filtro para cerrar fila de tabla. Si fueran una cantidad de productos
			// no múltiplos de 4, esto daría problemas, pero en este caso, como son 8, lo
			// dejamos así pues es más diseño que otra cosa.
			if (i % 4 != 0 && i % 4 == 3) {
				tabla.append("</tr>");
			}
		}

		return tabla;
	}
	
	public static StringBuilder crearSelectDeProductos (int stock, Integer id) {
		
		StringBuilder select = new StringBuilder();
		
		if (stock == 0) {
			
			select.append("<p style=\"color:red;\">Lo sentimos, no hay stock actualmente.</p>");
		
		// Como no queremos que se puedan comprar más de 10 a pesar de haber stock,
		// ponemos este filtro que impide que muestre más de 10 selects.
		} else if (stock >= 9){
			
			select.append("<select name=\"");
			select.append(id.toString());
			select.append("\" id=\"");
			select.append(id.toString());
			select.append("\">");
			for (int i = 0; i<=10; i++) {
				select.append("<option value=\"");
				select.append(String.valueOf(i));
				select.append("\" label=\"");
				select.append(String.valueOf(i));
				select.append("\">");
				select.append(String.valueOf(i));
				select.append("</option>");
			}
			select.append("</select>");
			
		} else {
			
			select.append("<select name=\"");
			select.append(id.toString());
			select.append("\" id=\"");
			select.append(id.toString());
			select.append("\">");
			for (int i = 0; i<=stock; i++) {
				select.append("<option value=\"");
				select.append(String.valueOf(i));
				select.append("\" label=\"");
				select.append(String.valueOf(i));
				select.append("\">");
				select.append(String.valueOf(i));
				select.append("</option>");
			}
			select.append("</select>");
			
		}
		
		return select;
	}

	/**
	 * Método para la contrucción de la tabla en la vista carrito.
	 * 
	 * @param carrito
	 * @return String
	 */
	public static StringBuilder convertirCarritoATabla(List<String> carrito) {

		// Se usa StringBuilder para elaboración dinámica del html
		// de forma rápida y eficaz.
		StringBuilder tabla = new StringBuilder();
		int count = 0;

		for (int i = 0; i < carrito.size(); i++) {

			count++;
			// Primer filtro para inicio de pintado de fila de tabla
			if (i % 3 == 0) {
				tabla.append("<tr>");
			}

			// Segundo filtro para rellenar con los distintos colores
			// ordenando por filas, para ello nos apoyamos en un contador.
			if (count < 4) {
				tabla.append("<td class=\"tg-0lax\">");
			} else {
				tabla.append("<td class=\"tg-dg7a\">");
				
				if (count == 6) count = 0;
			}

			// Tercer filtro para cerrar fila de tabla y calcular el
			// importe de la cantidad de productos por el precio del mismo.
			if (i % 3 != 0 && i % 3 == 2) {
				
				// Casteo de los parámetros recibidos de String a Double para hacer la multiplicación
				// y posterior añadido del resultado como String a la tabla.
				Double result = Double.parseDouble(carrito.get(i))*Double.parseDouble(carrito.get(i-1));
				
				tabla.append(result.toString());
				tabla.append(" Euros");
				tabla.append("</tr>");
			} else {
				tabla.append(carrito.get(i));
			}
		}

		return tabla;
	}
	
	/**
	 * Método para la impresión de la tabla con la lista de ventas.
	 * 
	 * @param listadoVentas
	 * @return StringBuilder
	 */
	public static StringBuilder convertirListadoVentasATabla(List<Order> listadoVentas) {
		
		// Se usa StringBuilder para elaboración dinámica del html
		// de forma rápida y eficaz.
		StringBuilder tabla = new StringBuilder();
		
		for (int i = 0; i < listadoVentas.size(); i++) {

			Order venta = listadoVentas.get(i);
			String cierreCelda = "</td>";
			
			tabla.append("<tr>");
			
			// Filtro para inicio de pintado de fila de tabla alternando colores.
			if (i%2 == 0) {
				tabla.append("<td class=\"tg-0lax\">");
				tabla.append(venta.getOrderID().toString());
				tabla.append(cierreCelda);
				tabla.append("<td class=\"tg-0lax\">");
				tabla.append(venta.getOrderDate().toString());
				tabla.append(cierreCelda);
				tabla.append("<td class=\"tg-0lax\">");
				tabla.append(venta.getBuyerID().toString());
				tabla.append(cierreCelda);
			} else {
				tabla.append("<td class=\"tg-dg7a\">");
				tabla.append(venta.getOrderID().toString());
				tabla.append(cierreCelda);
				tabla.append("<td class=\"tg-dg7a\">");
				tabla.append(venta.getOrderDate().toString());
				tabla.append(cierreCelda);
				tabla.append("<td class=\"tg-dg7a\">");
				tabla.append(venta.getBuyerID().toString());
				tabla.append(cierreCelda);
			}
		
			tabla.append("</tr>");
		}
		
		return tabla;
	}
}