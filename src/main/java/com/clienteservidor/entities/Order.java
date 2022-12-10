/**
 * 
 */
package com.clienteservidor.entities;

import java.util.Date;

/**
 * Clase Order para contrucción de venta que se traen de la base de datos. 
 * 
 * @author Jonatan Carrera Viera
 *
 */
public class Order {

	//Atributos de la clase Order con las columnas de la BBDD.
	private Integer orderID;
	private Date orderDate;
	private Integer buyerID;
	
	/**
	 * Método constructor vacío.
	 */
	public Order() {
		super();
	}

	/**
	 * Método constructor con parámetros.
	 * 
	 * @param orderID
	 * @param orderDate
	 * @param buyerID
	 */
	public Order(Integer orderID, Date orderDate, Integer buyerID) {
		super();
		this.orderID = orderID;
		this.orderDate = orderDate;
		this.buyerID = buyerID;
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
	 * @return the orderDate
	 */
	public Date getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the buyerID
	 */
	public Integer getBuyerID() {
		return buyerID;
	}

	/**
	 * @param buyerID the buyerID to set
	 */
	public void setBuyerID(Integer buyerID) {
		this.buyerID = buyerID;
	}
}
