/**
 * 
 */
package com.clienteservidor.entities;

/**
 * Clase OrderDetails para contrucción de detalles de venta que se traen de la base de datos. 
 * 
 * @author Jonatan Carrera Viera
 *
 */
public class OrderDetails {

	//Creación de atributos para la clase OrderDetails.
	private Integer orderID;
	private Integer productID;
	private int quantity;
	private Double priceEach;
	
	/**
	 * Método constructor vacío.
	 */
	public OrderDetails() {
		super();
	}

	/**
	 * Método constructor con parámetros.
	 * 
	 * @param orderID
	 * @param productID
	 * @param quantity
	 * @param priceEach
	 */
	public OrderDetails(Integer orderID, Integer productID, int quantity, Double priceEach) {
		super();
		this.orderID = orderID;
		this.productID = productID;
		this.quantity = quantity;
		this.priceEach = priceEach;
	}

	/**
	 * @return the orderID
	 */
	public Integer getOrderID() {
		return orderID;
	}

	/**
	 * @param orderID the orderID to set
	 */
	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}

	/**
	 * @return the productID
	 */
	public Integer getProductID() {
		return productID;
	}

	/**
	 * @param productID the productID to set
	 */
	public void setProductID(Integer productID) {
		this.productID = productID;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the priceEach
	 */
	public Double getPriceEach() {
		return priceEach;
	}

	/**
	 * @param priceEach the priceEach to set
	 */
	public void setPriceEach(Double priceEach) {
		this.priceEach = priceEach;
	}
}
