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

import com.clienteservidor.entities.Order;
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
		
		// Creación de importe total para mostrar importe total del carrito.
		Double importeTotalCarrito = 0d;
		
		// Array que almacena las cantidades de todos los productos que hayan marcado
		// para compra de forma dinámica, para mantener el dinamismo sin usar ni JS ni PHP
		// (Un poco ineficiente, pero para ajustarnos a la materia dada).
		ArrayList<String> carritoParaImprimir = new ArrayList<>();
		List <OrderDetails> detallesVenta = new ArrayList<>();
		
		for (int i = 0; i < listaProductos.size(); i++) {
			
			Product pTemporal = listaProductos.get(i);
			String idProductoTemporal = pTemporal.getProductID().toString();
			OrderDetails detallesVentaTemporal = new OrderDetails();
			
			// Se crea una condición para que si el producto seleccionado del getParameter es
			// igual a 0, no se añada al arraylist de carritoParaImprimir creado para impresión
			// en HTML, ni en la entidad detallesVenta que vamos a insertar en la DB.
			if (request.getParameter(idProductoTemporal) == null) {
				
				return new ModelAndView("index");
			} else if (!(request.getParameter(idProductoTemporal)).equalsIgnoreCase("0")) {
				carritoParaImprimir.add(pTemporal.getProductName());
				carritoParaImprimir.add(request.getParameter(pTemporal.getProductID().toString()));
				carritoParaImprimir.add(pTemporal.getPrice().toString());
				
				detallesVentaTemporal.setProductID(pTemporal.getProductID());
				detallesVentaTemporal.setQuantity(Integer.parseInt(request.getParameter(pTemporal.getProductID().toString())));
				detallesVentaTemporal.setPriceEach(pTemporal.getPrice());
				
				detallesVenta.add(detallesVentaTemporal);
				
				importeTotalCarrito += Double.parseDouble(request.getParameter(pTemporal.getProductID().toString())) * pTemporal.getPrice();
			}
		}
		
		String tablaCarrito = Utilidades.convertirCarritoATabla(carritoParaImprimir).toString();
		
		ModelAndView mav = new ModelAndView("carrito");
		mav.addObject("carrito", tablaCarrito);
		mav.addObject("importeTotal", importeTotalCarrito);
		request.getSession().setAttribute("orderDetails", detallesVenta);
		
		return mav;
	}
	
	@GetMapping("/realizarcompra")
	public ModelAndView compraIntranet(HttpServletRequest request) {
		
		// Se controla que no se puedan lanzar las instrucciones SQL sin que haya los datos necesarios para
		// realizar los cambios de forma segura y sin que falten campos.
		if (request.getSession().getAttribute("userID") != null && request.getSession().getAttribute("orderDetails") != null) {
			
			@SuppressWarnings("unchecked")
			List<OrderDetails> detallesVenta = (List<OrderDetails>) request.getSession().getAttribute("orderDetails");
			request.getSession().removeAttribute("orderDetails");
			
			// Se crea el objeto de Order para insertar una nueva venta.
			Order venta = new Order();
			
			// Creación del objeto venta para su inserción.
			venta.setBuyerID((Integer) request.getSession().getAttribute("userID"));
			
			// Inserción en DB de la venta.
			connection.insertOrder(venta);
			
			// Obtención del orderID que forma parte de la doble PK de la tabla orderdetails.
			Integer orderID = null;
			
			// Lanzamiento de query para la obtención de la última venta del usuario en sesión.
			Integer userID = (Integer) request.getSession().getAttribute("userID");
			List<Order> listaCompras = connection.getLastOrderFromAnUser(userID);
			orderID = listaCompras.get(0).getOrderID();
			
			// Bucle para inserción de todas las entradas de la tabla orderdetails añadiéndole el orderID de la Pk conjunta.
			for (int i = 0; i < detallesVenta.size(); i++) {
				OrderDetails detalleVentaUnitariaTemporal = detallesVenta.get(i);
				detalleVentaUnitariaTemporal.setOrderID(orderID);
				
				// Inserción en DB de cada detalle de venta en orderdetails
				connection.insertOrderDetails(detalleVentaUnitariaTemporal);
			}
			
			// Se añade mensaje de realización de compra al request para la vista.
			ModelAndView mav = new ModelAndView("realizarcompra");
			mav.addObject("mensaje", "Gracias por su compra, esperamos volver a verle pronto.");
			
			return mav;
			
		} else {
			
			// Se añade mensaje en caso de que falte algún parámetro para realizar el registro de la compra.
			ModelAndView mav = new ModelAndView("realizarcompra");
			mav.addObject("mensaje", "Ha ocurrido un error inesperado, inténtelo más tarde.");
			
			return mav;
		}
	}
}
