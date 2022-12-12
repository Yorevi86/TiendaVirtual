/**
 * 
 */
package com.clienteservidor.persistence.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.clienteservidor.entities.MappedProduct;
import com.clienteservidor.entities.MappedUser;
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
}
