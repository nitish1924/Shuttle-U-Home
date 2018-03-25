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
}
