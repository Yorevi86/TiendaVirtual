/**
 * 
 */
package com.clienteservidor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.clienteservidor.entities.Order;
import com.clienteservidor.persistence.repositories.DBUtils;
import com.clienteservidor.utilities.Utilidades;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Controlador de la página del listado de ventas.
 * 
 * @author Jonatan Carrera Viera
 *
 */
@Controller
public class ListaVentasController {

	@Autowired
	DBUtils connection;

	@GetMapping("/listadoventas")
	public ModelAndView listadoVentasIntranet(HttpServletRequest request) {

		System.out.println(request.getSession().getAttribute("admin"));
		
		if (request.getSession().getAttribute("admin") == null) {

			return new ModelAndView("index");
		} else if ((String.valueOf(request.getSession().getAttribute("admin"))).equalsIgnoreCase("1")) {

			List<Order> listaVentas = connection.obtainAllOrders();
			String tablaListadoVentas = Utilidades.convertirListadoVentasATabla(listaVentas).toString();

			ModelAndView mav = new ModelAndView("listadoventas");
			mav.addObject("tablaListadoVentas", tablaListadoVentas);

			return mav;
		} else
			return new ModelAndView("index");
	}
}
