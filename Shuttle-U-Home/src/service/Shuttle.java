package service;

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
public String loginOTP(String email,String otp) {
	StudentDAO studentDAO=new StudentDAO();
	return studentDAO.loginOTP(email,otp);
}
}
