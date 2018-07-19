/////////////////////////////////////////////////////////////////////////////
//  Employee.java - File Holds the information of Employees(admin & driver)//
//  version 2.0  (Date - 03/25/2018)                                       //
//  Language:    Java                                                      //
//  Platform:    Windows 10 Pro                                            //
//  Application: Shuttle U Home CSE686 - Internet Programming              //
//  Author:      Shweta Shukla, Syracuse University                        //
/////////////////////////////////////////////////////////////////////////////
/*
 *   Purpose
 *   ------------------
 *   This Java file holds all the attributes of Employee/ Driver.
 *   Attributes for Employees  are name,email, phone, password
 *   There are getter and setter method for each attribute to fetch the required attribute or set the required attribute accordingly.
 */
package bean;

public class Employee {
	private int id;            // upon successful creation of employee by admin, a id value is returned.
	private String name;       // name of Employee / Driver 
	private String emailId;    // Email id of employee
	private long phoneNo;      // phone number of employee
	private String password;   // password to login
	
	
	// Below are the getter and setter method for each attribute to set or fetch the required attribute.
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmailId() {
		return emailId;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
