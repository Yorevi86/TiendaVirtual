/**
 * 
 */
package com.clienteservidor.entities;

/**
 * Clase Product para contrucción de productos que se traen de la base de datos. 
 * 
 * @author Jonatan Carrera Viera
 *
 */
public class Product {
	
	//Atributos de la clase Product con las columnas de la BBDD.
	private Integer productID;
	private String productName;
	private int stock;
	private String description;
	private Double price;
	
	/**
	 * Método constructor vacío.
	 */
	public Product() {
		super();
	}

	/**
	 * Método constructor con parámetros.
	 * 
	 * @param productID
	 * @param productName
	 * @param stock
	 * @param description
	 * @param price
	 */
	public Product(Integer productID, String productName, int stock, String description, Double price) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.stock = stock;
		this.description = description;
		this.price = price;
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
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the stock
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
}
