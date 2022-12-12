/**
 * 
 */
package com.clienteservidor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.clienteservidor.persistence.repositories.DBUtils;

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
}
