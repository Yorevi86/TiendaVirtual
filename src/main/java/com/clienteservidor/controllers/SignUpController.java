/**
 * 
 */
package com.clienteservidor.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.clienteservidor.entities.User;
import com.clienteservidor.persistence.repositories.DBUtils;
import com.clienteservidor.utilities.Utilidades;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Controlador de la página de cierre de sesión.
 * 
 * @author Jonatan Carrera Viera
 *
 */
@Controller
public class SignUpController {

	@Autowired
	protected DBUtils connection;

	@GetMapping("/signup")
	public ModelAndView signupIntranet(HttpServletRequest request) {

		return new ModelAndView("signup");
	}

	@GetMapping("/modificardireccion")
	public ModelAndView modifyAddressIntranet(HttpServletRequest request) {

		// Se recoge el QueryString de la compra para realizar la redirección
		// a tienda tras modificar los datos.
		String redireccion = (String) request.getAttribute("compra");

		// Creación de String de errores de validación.
		String errors = "";

		if (request.getSession().getAttribute("name") == null) {

			return new ModelAndView("index");
		} else {

			User usuarioTemp = new User();

			usuarioTemp.setUserID((Integer) request.getSession().getAttribute("userID"));
			usuarioTemp.setAddress(request.getParameter("address"));
			usuarioTemp.setState(request.getParameter("state"));
			usuarioTemp.setCity(request.getParameter("city"));
			usuarioTemp.setPostalCode(request.getParameter("postalCode"));

			// Validación de los datos usando el método addressValidation de la clase utilidades.
			Map<String, String> validation = Utilidades.addressValidation(usuarioTemp);

			for (Map.Entry<String, String> data : validation.entrySet()) {

				// Se recogen los datos que han fallado en un String para su posterior envío
				// a la vista del controlador.
				if (!data.getValue().equalsIgnoreCase("ok")) {
					errors += (data.getKey() + data.getValue() + "\n");
				}
			}
			
			// Si está libre de errores, se registra al usuario en la DB.
			if(errors.isEmpty()) {
				connection.alterAddress(usuarioTemp);
				
				// Se envía al usuario a la página de login para poder conectarse.
				return new ModelAndView("carrito" + redireccion);
			} else {
				
				// Si hay errores, se envía al cliente de vuelta a signup y se añade
				// a la vista el String con los datos erróneos.
				ModelAndView mav = new ModelAndView("carrito" + redireccion);
				mav.addObject("errores", errors);
				
				return mav;
			}
		}
	}
}
