/////////////////////////////////////////////////////////////////////////////
//  Booking.java - Holds holds all the attribute for Shuttle booking       //
//  version 2.0  (Date - 03/25/2018)                                       //
//  Language:    Java                                                      //
//  Platform:    Windows 10 Pro                                            //
//  Application: Shuttle U Home CSE686 - Internet Programming              //
//  Author:      Nitish Kumar, Syracuse University                         //
/////////////////////////////////////////////////////////////////////////////
/*
 *   Purpose
 *   ------------------
 *   This Java file holds all the attribute for Shuttle booking.
 *   Attributes for booking are name, address, email, date, status, driver 
 *   There are getter and setter method for each attribute to fetch the required attribute or set the required attribute accordingly.
 */
package bean;

public class Booking {
	
	private String name;     //Student Name who have booked the shuttle
	private String address;  // Drop address
	private String email;    // Email of student
	private String date;     // Date of booking
	private String status;   // Booking status (Booked or Cancelled or traveled)
	private String driver;   // Driver name in the booking table would be updated when the student is dropped at home.
	
	// Below are the getter and setter method for each attribute to set or fetch the required attribute.
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public void setStatus(String status) {
		this.status=status;
		
	}
	public String getStatus() {
		return status;
	}
	
}
