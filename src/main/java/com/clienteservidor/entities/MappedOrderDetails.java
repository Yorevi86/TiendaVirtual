/**
 * 
 */
package com.clienteservidor.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * Clase para la construcción de los objetos OrderDetails que vienen de la BBDD. 
 * 
 * @author Jonatan Carrera Viera
 *
 */
public class MappedOrderDetails implements RowMapper<OrderDetails>{
	
	@Override
	public OrderDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		OrderDetails detallesPedido = new OrderDetails();
		
		detallesPedido.setOrderID(rs.getInt("orderID"));
		detallesPedido.setProductID(rs.getInt("productID"));
		detallesPedido.setQuantity(rs.getInt("quantity"));
		detallesPedido.setPriceEach(rs.getDouble("priceEach"));
		
		return detallesPedido;
	}

}
