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
import jakarta.servlet.http.HttpSession;

/**
 * Controlador de la página index.
 * 
 * @author Jonatan Carrera Viera
 *
 */
@Controller
public class IndexController {

	@Autowired
	protected DBUtils connection;
	
	@GetMapping("/index")
	public ModelAndView indexIntranet(HttpServletRequest request) {

		HttpSession session = request.getSession(true);
		session.setAttribute("validation", null);
		
		return new ModelAndView("index");
	}
	
}
