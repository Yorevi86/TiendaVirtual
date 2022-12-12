/**
 * 
 */
package com.clienteservidor.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Controlador de la página login.
 * 
 * @author Jonatan Carrera Viera
 *
 */
@Controller
public class LoginController {

	@GetMapping("/login")
	public ModelAndView loginIntranet(HttpServletRequest request) {
		
		return new ModelAndView("login");
	}
}
