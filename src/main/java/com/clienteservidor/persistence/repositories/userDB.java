/**
 * 
 */
package com.clienteservidor.persistence.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.clienteservidor.entities.MappedUser;
import com.clienteservidor.entities.User;

/**
 * Clase repositorio para la inyección de template y ejecución de consultas SQL para User.
 * 
 * @author Jonatan Carrera Viera
 *
 */
@Repository
public class userDB {

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
		String sql = "SELECT * FROM usuarios WHERE login='" + login + "' AND password='" + password + "'";
		
		return template.query(sql, new MappedUser());
	}
}
