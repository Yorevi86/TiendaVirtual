/**
 * 
 */
package com.clienteservidor.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Controlador de la página de cierre de sesión.
 * 
 * @author Jonatan Carrera Viera
 *
 */
@Controller
public class LogoutController {

	@GetMapping("/logout")
	public ModelAndView loginIntranet(HttpServletRequest request) {

		request.getSession().invalidate();

		return new ModelAndView("redirect:/index");

	}
}
