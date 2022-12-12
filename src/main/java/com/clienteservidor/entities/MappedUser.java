/**
 * 
 */
package com.clienteservidor.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * Clase para la construcción de los objetos User que vienen de la BBDD. 
 * 
 * @author Jonatan Carrera Viera
 *
 */
public class MappedUser implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		User usuario = new User();
		
		usuario.setUserID(rs.getInt("userID"));
		usuario.setName(rs.getString("name"));
		usuario.setSurname(rs.getString("surname"));
		usuario.setLogin(rs.getString("login"));
		usuario.setAddress(rs.getString("address"));
		usuario.setState(rs.getString("state"));
		usuario.setCity(rs.getString("city"));
		usuario.setPostalCode(rs.getString("postalCode"));
		usuario.setPhoneNumber(rs.getString("phoneNumber"));
		usuario.setAdmin(rs.getInt("admin"));
		usuario.setPassword(rs.getString("password"));
		
		return usuario;
	}
}
