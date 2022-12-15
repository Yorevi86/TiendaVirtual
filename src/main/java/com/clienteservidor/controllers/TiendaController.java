/**
 * 
 */
package com.clienteservidor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.clienteservidor.entities.Product;
import com.clienteservidor.entities.User;
import com.clienteservidor.persistence.repositories.DBUtils;
import com.clienteservidor.utilities.Utilidades;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Controlador de la página tienda.
 * 
 * @author Jonatan Carrera Viera
 *
 */
@Controller
public class TiendaController {

	@Autowired
	protected DBUtils connection;

	@GetMapping("/tienda")
	public ModelAndView tiendaIntranet(HttpServletRequest request) {

		// Variable para adjuntarle el objeto String que se genera
		// de la query obtainAllProducts() solo para la vista "tienda"
		ModelAndView mav = new ModelAndView("tienda");
		
		// Creación de objeto User para validaciones en DB.
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		// Query para obtener el usuario indicado con login y password.
		List<User> listaUsuario = connection.obtainUser(login, password);
		
		// Query para obtener todos los productos de la tienda en la DB.
		List<Product> listaProductos = connection.obtainAllProducts();
		
		// Un string para la construcción del texto que luego se convierte en la
		// tabla que se mostrará en el .jsp y que adjuntaremos al request
		// de la vista de "tienda".
		String catalogo = Utilidades.convertirListaProductosATabla(listaProductos);
		
		mav.addObject("catalogo", catalogo);

		// Comprobación para saber si hay sesión con atributos asignados o no y
		// si su validación de contraseña es ko o no, para redirigir al login con
		// mensaje
		// de error de usuario y/o contraseña erróneos.
		if (request.getSession().getAttribute("name") != null) {
			
			return mav;

		} else if (!listaUsuario.isEmpty()) {

			// Al haber usuario, se guarda toda su info en la sesión para su uso posterior.
			request.getSession().setAttribute("validation", "ok");
			request.getSession().setAttribute("validationMessage", null);
			request.getSession().setAttribute("name", listaUsuario.get(0).getName());
			request.getSession().setAttribute("surname", listaUsuario.get(0).getSurname());
			request.getSession().setAttribute("address", listaUsuario.get(0).getAddress());
			request.getSession().setAttribute("state", listaUsuario.get(0).getState());
			request.getSession().setAttribute("city", listaUsuario.get(0).getCity());
			request.getSession().setAttribute("postalCode", listaUsuario.get(0).getPostalCode());
			request.getSession().setAttribute("phoneNumber", listaUsuario.get(0).getPhoneNumber());
			request.getSession().setAttribute("admin", listaUsuario.get(0).getAdmin());

			return mav;

		} else if (request.getSession().getAttribute("name") == null && listaUsuario.isEmpty()
				&& login == null && password == null) {

			return mav;

		} else {

			String respuesta = "Usuario o contraseña incorrecto.<br>Vuelva a intentarlo.";
			request.getSession().setAttribute("validationMessage", respuesta);

			return new ModelAndView("login");
		}
	}
}
