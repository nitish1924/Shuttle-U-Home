/////////////////////////////////////////////////////////////////////////////
//  Shuttle.java - It is an java file of service layer                     //
//  version 4.0  (Date - 04/15/2018)                                       //
//  Language:    Java                                                      //
//  Platform:    Windows 10 Pro                                            //
//  Application: Shuttle U Home CSE686 - Internet Programming              //
//  Author:      Nitish Kumar, Syracuse University                         //
/////////////////////////////////////////////////////////////////////////////
/*
 *   Purpose
 *   ------------------
 *  This Service layer file of MVC architecture interacts directly with StudentDAO(database access file) and servlet(Studentcontroller)
 *  Receives action to do from servlet (StudentController.Java) and forward the action to Studentcontroller.java and vice-versa
 *   
 */

package service;

import java.util.ArrayList;

import bean.Booking;
import bean.Employee;
import bean.Student;
import dao.StudentDAO;

public class Shuttle {
	public int createStudent(Student student) // For student registration student object received from servlet send to DAO file.
	{
		StudentDAO studentDAO= new StudentDAO();
		return studentDAO.createStudent(student);
	}
public String login(String emailId,String Password) { //login authentication send to DAO file.
	StudentDAO studentDao=new StudentDAO();
	return studentDao.login(emailId,Password);
}
public String[] loginOTP(String email,String otp) { // otp authentication send to DAO file.
	StudentDAO studentDAO=new StudentDAO();
	return studentDAO.loginOTP(email,otp);
}
public void createBooking(Booking book) { // to create booking booking object send to DAO file.
	StudentDAO studentDAO=new StudentDAO();
	studentDAO.createBooking(book);
}
public String driverLogin(String email, String password) { // driver authentication
	StudentDAO studentDAO=new StudentDAO();
	return studentDAO.driverLogin(email,password);
}
public ArrayList<Booking> createList(String dname) { // driver fetch booking list
	StudentDAO studentDAO=new StudentDAO();
	return studentDAO.createList(dname);
	
}
public ArrayList<Booking> viewbooklist(String email) { // student view their booking list
	StudentDAO studentDAO=new StudentDAO();
	return studentDAO.viewbooklist(email);
}
public void cancel(String email) {                   // cancellation of booking
	StudentDAO studentDAO=new StudentDAO();
	studentDAO.cancel(email);
}
public int createEmployee(Employee emp) {              // driver registartion  invoked by admin
	StudentDAO studentDAO=new StudentDAO();
	return studentDAO. createEmployee(emp);
}
public ArrayList<Booking>  viewbookingsadmin() {   // admin request view all shuttle booking
	StudentDAO studentDAO=new StudentDAO();
	return studentDAO.viewbookingsadmin();
	
	
}
public String forgotPassword(String email) {  // user invokes forget password to retrieve his/her password
	StudentDAO studentDAO=new StudentDAO();
	String status = studentDAO.forgotPassword(email);
	return status;
}
public void changePassword(String email, String pass) {   // user changes his password
	StudentDAO studentDAO=new StudentDAO();
	studentDAO.changePassword(email,pass);
	
}
	
}

