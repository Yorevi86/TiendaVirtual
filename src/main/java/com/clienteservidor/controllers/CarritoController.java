/**
 * 
 */
package com.clienteservidor.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.clienteservidor.entities.OrderDetails;
import com.clienteservidor.entities.Product;
import com.clienteservidor.persistence.repositories.DBUtils;
import com.clienteservidor.utilities.Utilidades;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Controlador de la página carrito.
 * 
 * @author Jonatan Carrera Viera
 *
 */
@Controller
public class CarritoController {
	
	@Autowired
	DBUtils connection;
	
	@GetMapping("/carrito")
	public ModelAndView carritoIntranet(HttpServletRequest request) {
		
		// Query para obtener todos los productos de la tienda en la DB.
		List<Product> listaProductos = connection.obtainAllProducts();
		
		// Se recoge los datos de compra en un string para redirigir de nuevo a
		// carrito con la compra ya rellena en la modificación de la dirección.
		String carritoInfo = request.getQueryString();
		
		// Creación de importe total para mostrar importe total del carrito.
		Double importeTotalCarrito = 0d;
		
		// Array que almacena las cantidades de todos los productos que hayan marcado
		// para compra de forma dinámica, para mantener el dinamismo sin usar ni JS ni PHP
		// (Un poco ineficiente, pero para ajustarnos a la materia dada).
		ArrayList<String> carritoParaImprimir = new ArrayList<>();
		OrderDetails detallesVenta = new OrderDetails();
		
		for (int i = 0; i < listaProductos.size(); i++) {
			
			Product pTemporal = listaProductos.get(i);
			String idProductoTemporal = pTemporal.getProductID().toString();
			
			// Se crea una condición para que si el producto seleccionado del getParameter es
			// igual a 0, no se añada al arraylist de carritoParaImprimir creado para impresión
			// en HTML, ni en la entidad detallesVenta que vamos a insertar en la DB.
			if (request.getParameter(idProductoTemporal) == null) {
				
				return new ModelAndView("index");
			} else if (!(request.getParameter(idProductoTemporal)).equalsIgnoreCase("0")) {
				carritoParaImprimir.add(pTemporal.getProductName());
				carritoParaImprimir.add(request.getParameter(pTemporal.getProductID().toString()));
				carritoParaImprimir.add(pTemporal.getPrice().toString());
				
				detallesVenta.setProductID(pTemporal.getProductID());
				detallesVenta.setQuantity(Integer.parseInt(request.getParameter(pTemporal.getProductID().toString())));
				detallesVenta.setPriceEach(pTemporal.getPrice());
				
				importeTotalCarrito += Double.parseDouble(request.getParameter(pTemporal.getProductID().toString())) * pTemporal.getPrice();
			}
		}
		
		String tablaCarrito = Utilidades.convertirCarritoATabla(carritoParaImprimir).toString();
		
		ModelAndView mav = new ModelAndView("carrito");
		mav.addObject("compra", carritoInfo);
		mav.addObject("carrito", tablaCarrito);
		mav.addObject("importeTotal", importeTotalCarrito);
		
		return mav;
	}
}
