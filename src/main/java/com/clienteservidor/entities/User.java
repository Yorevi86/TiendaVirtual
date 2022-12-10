/**
 * 
 */
package com.clienteservidor.entities;

/**
 * Clase User para contrucción de usuarios que se traen de la base de datos. 
 * 
 * @author Jonatan Carrera Viera
 *
 */
public class User {

	//Atributos de la clase User con las columnas de la BBDD.
	private Integer userID;
	private String name;
	private String surname;
	private String address;
	private String state;
	private String city;
	private String postalCode;
	private String phoneNumber;
	private boolean admin;
	private String password;
	
	/**
	 * Método constructor vacío.
	 */
	public User() {
		super();
	}

	/**
	 * Método constructor con parámetros.
	 * 
	 * @param userID
	 * @param name
	 * @param surname
	 * @param address
	 * @param state
	 * @param city
	 * @param postalCode
	 * @param phoneNumber
	 * @param admin
	 * @param password
	 */
	public User(Integer userID, String name, String surname, String address, String state, String city,
			String postalCode, String phoneNumber, boolean admin, String password) {
		super();
		this.userID = userID;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.state = state;
		this.city = city;
		this.postalCode = postalCode;
		this.phoneNumber = phoneNumber;
		this.admin = admin;
		this.password = password;
	}

	/**
	 * @return the userID
	 */
	public Integer getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the admin
	 */
	public boolean isAdmin() {
		return admin;
	}

	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}	
}
