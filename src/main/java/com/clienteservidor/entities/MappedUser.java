/**
 * 
 */
package com.clienteservidor.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.clienteservidor.utilities.Utilidades;

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
		usuario.setAddress(rs.getString("address"));
		usuario.setState(rs.getString("state"));
		usuario.setCity(rs.getString("city"));
		usuario.setPostalCode(rs.getString("postalCode"));
		usuario.setPhoneNumber(rs.getString("phoneNumber"));
		//Uso de método para convertir el int que se recibe de BBDD por el tipo bit a boolean.
		usuario.setAdmin(Utilidades.convertIntToBoolean(rs.getInt("admin")));
		usuario.setPassword(rs.getString("password"));
		
		return usuario;
	}
}
