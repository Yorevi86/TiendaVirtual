/**
 * 
 */
package com.clienteservidor.persistence.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import com.clienteservidor.entities.MappedOrder;
import com.clienteservidor.entities.MappedProduct;
import com.clienteservidor.entities.MappedUser;
import com.clienteservidor.entities.Order;
import com.clienteservidor.entities.OrderDetails;
import com.clienteservidor.entities.Product;
import com.clienteservidor.entities.User;

/**
 * Clase repositorio para la inyección de template y ejecución de consultas SQL para User.
 * 
 * @author Jonatan Carrera Viera
 *
 */
@Repository
public class DBUtils {

	@Autowired
	protected JdbcTemplate template;
	
	/**
	 * Método para buscar un usuario por login y contraseña.
	 * 
	 * @param login
	 * @param password
	 * @return List<User>
	 */
	public List<User> obtainUser(String login, String password) {
		
		String sql = "SELECT * FROM users WHERE login='" + login + "' AND password='" + password + "';";
		
		return template.query(sql, new MappedUser());
	}
	
	/**
	 * Método para obtener una lista de todos los productos de la DB.
	 * 
	 * @return List<Product>
	 */
	public List<Product> obtainAllProducts(){
		
		String sql = "SELECT * FROM products";
		
		return template.query(sql, new MappedProduct());
	}
	
	/**
	 * Método para obtener una lista de ventas ordenadas descendientemente por el ID.
	 * 
	 * @return List<Order>
	 */
	public List<Order> obtainAllOrders(){
		
		String sql = "SELECT * FROM orders ORDER BY orderID DESC";
		
		return template.query(sql, new MappedOrder());
	}
	
	/**
	 * Método para insertar un usuario en la DB.
	 * 
	 * @param usuario
	 */
	public void insertUser (User usuario) {
		
		String sql = "INSERT INTO users(name, surname, login, address, state, city, postalCode, phoneNumber, admin, password) VALUES ('"
				+ usuario.getName() + "', '"
				+ usuario.getSurname() + "', '"
				+ usuario.getLogin() + "', '"
				+ usuario.getAddress() + "', '"
				+ usuario.getState() + "', '"
				+ usuario.getCity() + "', '"
				+ usuario.getPostalCode() + "', '"
				+ usuario.getPhoneNumber() + "', "
				+ usuario.getAdmin() + ", '"
				+ usuario.getPassword() + "');";
				
		template.execute(sql);
	}
	
	/**
	 * Método para modificar la dirección de un cliente.
	 * 
	 * @param usuario
	 */
	public void alterAddress (User usuario) {
		
		String sql = "UPDATE users SET address='" + usuario.getAddress() + "', state='" + usuario.getState() + "', city='"
				+ usuario.getCity() + "', postalCode='" + usuario.getPostalCode() +"' WHERE userID='" + usuario.getUserID()
				+ "';";
		
		template.execute(sql);
	}
	
	/**
	 * Método para insertar una venta en la tabla orders.
	 * 
	 * @param venta
	 */
	public void insertOrder (Order venta) {
		
		String sql = "INSERT INTO orders(orderDate, buyerID) VALUES ('"
				+ LocalDate.now() + "', "
				+ venta.getBuyerID() + ");"
				;
		
		template.execute(sql);
		
	}
	
	/**
	 * Método para obtener la última compra de un cliente.
	 * 
	 * @param usuario
	 * @return List<Order>
	 */
	public List<Order> getLastOrderFromAnUser (Integer idUsuario){
		
		String sql = "SELECT * FROM orders WHERE buyerID=" + idUsuario + " ORDER BY orderID DESC LIMIT 1";
		
		return template.query(sql, new MappedOrder());
	}
	
	/**
	 * Método para insertar un detalle de venta en la tabla orderdetails.
	 * 
	 * @param detallesVenta
	 */
	public void insertOrderDetails (OrderDetails detallesVenta) {
		
		String sql = "INSERT INTO orderdetails(orderID, productID, quantity, priceEach) VALUES ("
				+ detallesVenta.getOrderID() + ", "
				+ detallesVenta.getProductID() + ", "
				+ detallesVenta.getQuantity() + ", "
				+ detallesVenta.getPriceEach() + ");";
				
		template.execute(sql);
		
	}
}
