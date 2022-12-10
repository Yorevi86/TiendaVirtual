/**
 * 
 */
package com.clienteservidor.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * Clase para la construcción de los objetos Order que vienen de la BBDD. 
 * 
 * @author Jonatan Carrera Viera
 *
 */
public class MappedOrder implements RowMapper<Order>{

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Order venta = new Order();
		
		venta.setOrderID(rs.getInt("orderID"));
		venta.setOrderDate(rs.getDate("orderDate"));
		venta.setBuyerID(rs.getInt("buyerID"));
		
		return venta;
	}
}
