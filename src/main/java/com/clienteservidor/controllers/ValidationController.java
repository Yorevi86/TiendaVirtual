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
public class ValidationController {

	@Autowired
	protected DBUtils connection;
	
	@GetMapping("/validation")
	public ModelAndView validationIntranet(HttpServletRequest request) {
		
		// Creación de objeto User para validaciones en controlador.
		User user1 = new User();
		// Creación de String de errores de validación.
		String errors = "";
		
		// Asignación de atributos para el objeto User a validar.
		user1.setName(request.getParameter("name"));
		user1.setSurname(request.getParameter("surname"));
		user1.setLogin(request.getParameter("login"));
		user1.setAddress(request.getParameter("address"));
		user1.setState(request.getParameter("state"));
		user1.setCity(request.getParameter("city"));
		user1.setPostalCode(request.getParameter("postalCode"));
		user1.setPhoneNumber(request.getParameter("phoneNumber"));
		user1.setAdmin(0);
		user1.setPassword(request.getParameter("password"));
		
		// Validación de los datos usando el método validaton de la clase utilidades.
		Map<String, String> validation = Utilidades.validation(user1);
		
		for (Map.Entry<String, String> data : validation.entrySet()) {
			
			// Se recogen los datos que han fallado en un String para su posterior envío
			// a la vista del controlador.
			if(!data.getValue().equalsIgnoreCase("ok")) {
				errors += (data.getKey() + data.getValue() + "\n");
			}
		}
		
		// Si está libre de errores, se registra al usuario en la DB.
		if(errors.isEmpty()) {
			connection.insertUser(user1);
			
			// Se envía al usuario a la página de login para poder conectarse.
			return new ModelAndView("login");
		} else {
			
			// Si hay errores, se envía al cliente de vuelta a signup y se añade
			// a la vista el String con los datos erróneos.
			ModelAndView mav = new ModelAndView("signup");
			mav.addObject("errores", errors);
			
			return mav;
		}
	}
}
