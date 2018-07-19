/////////////////////////////////////////////////////////////////////////////
//  Student.java - File Holds the information of Students                  //
//  version 2.0  (Date - 03/25/2018)                                       //
//  Language:    Java                                                      //
//  Platform:    Windows 10 Pro                                            //
//  Application: Shuttle U Home CSE686 - Internet Programming              //
//  Author:      Nitish Kumar, Syracuse University                         //
/////////////////////////////////////////////////////////////////////////////
/*
 *   Purpose
 *   ------------------
 *   This Java file holds all the attributes of Students.
 *   Attributes for students are name, address, email, phone, password, gender.
 *   There are getter and setter method for each attribute to fetch the required attribute or set the required attribute accordingly.
 */
package bean;

public class Student {
	private int id;             // upon successful registration of student, a id value is returned.
	private String name;        // Name of student
	private String address;     // address of student
	private String emailId;     // email of student
	private long phoneNo;       // phone number of student
	private String password;    // password of the student
	private String gender;      // gender of the student
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}


}
