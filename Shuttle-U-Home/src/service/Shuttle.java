package service;

import java.util.ArrayList;

import bean.Booking;
import bean.Student;
import dao.StudentDAO;

public class Shuttle {
	public int createStudent(Student student)
	{
		StudentDAO studentDAO= new StudentDAO();
		return studentDAO.createStudent(student);
	}
public String login(String emailId,String Password) {
	StudentDAO studentDao=new StudentDAO();
	return studentDao.login(emailId,Password);
}
public String[] loginOTP(String email,String otp) {
	StudentDAO studentDAO=new StudentDAO();
	return studentDAO.loginOTP(email,otp);
}
public void createBooking(Booking book) {
	StudentDAO studentDAO=new StudentDAO();
	studentDAO.createBooking(book);
}
public String driverLogin(String email, String password) {
	StudentDAO studentDAO=new StudentDAO();
	return studentDAO.driverLogin(email,password);
}
public ArrayList<Booking> createList(String dname) {
	StudentDAO studentDAO=new StudentDAO();
	return studentDAO.createList(dname);
	
}
public ArrayList<Booking> viewbooklist(String email) {
	StudentDAO studentDAO=new StudentDAO();
	return studentDAO.viewbooklist(email);
}
}
