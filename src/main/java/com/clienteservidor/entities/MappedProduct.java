/**
 * 
 */
package com.clienteservidor.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * Clase para la construcción de los objetos Product que vienen de la BBDD. 
 * 
 * @author Jonatan Carrera Viera
 *
 */
public class MappedProduct implements RowMapper<Product>{

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Product producto = new Product();
		
		producto.setProductID(rs.getInt("productID"));
		producto.setProductName(rs.getString("productName"));
		producto.setStock(rs.getInt("stock"));
		producto.setDescription(rs.getString("description"));
		producto.setPrice(rs.getDouble("price"));
		
		return producto;
	}
}
