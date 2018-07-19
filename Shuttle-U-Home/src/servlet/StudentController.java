/////////////////////////////////////////////////////////////////////////////
//  StudentController.java-This is servlet file which interact via get/post//
//  version 5.0  (Date - 04/16/2018)                                       //
//  Language:    Java                                                      //
//  Platform:    Windows 10 Pro                                            //
//  Application: Shuttle U Home CSE686 - Internet Programming              //
//  Author:      Nitish Kumar/Shweta Shukla, Syracuse University           //
/////////////////////////////////////////////////////////////////////////////
/*
 *   Purpose
 *   ------------------
 *   This Servlet file interacts via get or post method with JSP and service layer i.e. Shuttle.java.
 *   
 */

package servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Booking;
import bean.Employee;
import bean.Student;
import service.EmailOTP;
import service.EmailPassword;
import service.Shuttle;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post method
		String action=request.getParameter("action"); // fetching the action(hidden field on every jsp file) to decode what action need to be performed
		HttpSession session=request.getSession();
		if("addStudent".equals(action)) // registration of student
		{
			Student student= new Student();
			// fetching the student details from registartion.jsp file and accesing the setter method of student.java 
			student.setName(request.getParameter("studentName"));
			student.setGender(request.getParameter("sex"));
			student.setAddress(request.getParameter("add")+" Syracuse");
			student.setEmailId(request.getParameter("eid"));
			student.setPhoneNo(Long.parseLong(request.getParameter("phone")));
			student.setPassword(request.getParameter("pwd"));
			
		
			Shuttle shuttle= new Shuttle ();
			int studentID = 0;
			try {
				studentID = shuttle.createStudent(student); // shuttle service is invoked to make an entry for student in DB.
				System.out.println(studentID);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(studentID==0){
				// if student is already registered open registration.jsp page again and print the error message
				response.setContentType("text/html"); 
				PrintWriter pw=response.getWriter();
						pw.print("Email id already registered!!Register using different email id");
			     request.getRequestDispatcher("Registration.jsp").include(request, response); 
			}
			else{
				// if registration is successful then open Login.jsp page
				response.setContentType("text/html"); 
				PrintWriter pw=response.getWriter();
						pw.print("Registered Successfully!Please Login");
			     request.getRequestDispatcher("Login.jsp").include(request, response); 
		      }
		 }  
		if("addEmployee".equals(action)) // registering the employee/ driver in db by invoking shuttle service
		{
			Employee emp= new Employee();
			
			emp.setName(request.getParameter("empName"));
		    emp.setEmailId(request.getParameter("eid"));
			emp.setPhoneNo(Long.parseLong(request.getParameter("phone")));
			emp.setPassword(request.getParameter("pwd"));
			
		
			Shuttle shuttle= new Shuttle ();
			int empID = 0;
			try {
				empID = shuttle.createEmployee(emp);
				System.out.println(empID);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(empID==0){
				// if employee already registerd then provide the error message
				response.setContentType("text/html"); 
				PrintWriter pw=response.getWriter();
						pw.print("Email id already registered!!Register using different email id");
			     request.getRequestDispatcher("EmployeeRegister.jsp").include(request, response); 
			}
			else{
				// successful registration of employee
				response.setContentType("text/html"); 
				PrintWriter pw=response.getWriter();
						pw.print("Employee Registered Successfully!");
			     request.getRequestDispatcher("AdminHome.jsp").include(request, response); 
		      }
		 }  
		if("login".equals(action)) {
			//login authentiaction for student/emplolyee
			Shuttle s=new Shuttle();
			String email=request.getParameter("seid");
			String pwd=request.getParameter("spwd");
			String identity =request.getParameter("identity"); // checking who accessed the login portal (student/employee)
			
			if(identity.equals("Student")) { // if accessed by student
				
			String name=s.login(email,pwd);
			if(name.equals("1234")) {
				// if authentication fails provide error message
				System.out.println("authentication failed");
				response.setContentType("text/html"); 
				PrintWriter pw=response.getWriter();
						pw.print("your email id or password is wrong.....try again");
			     request.getRequestDispatcher("Login.jsp").include(request, response); 
				
			}
			else { // if authentication successful for student create otp and authentiacte it from LoginOTP.jsp page
				System.out.println("text authentication success");
				EmailOTP e= new EmailOTP();
				e.createotp(email);
				session.setAttribute("email",email);
				
				request.getRequestDispatcher("LoginOTP.jsp").forward(request, response); 
			}
			}
			else {
				// if authentication fails for employee or admin provide error message
				Shuttle s1 = new Shuttle();
				String name=s1.driverLogin(email, pwd);
				if(name.equals("1234")) {
					System.out.println("authentication failed");
					response.setContentType("text/html"); 
					PrintWriter pw=response.getWriter();
							pw.print("your email id or password is wrong.....try again");
				     request.getRequestDispatcher("Login.jsp").include(request, response); 
					
				}
				else {
					// if employee authentication pass then check if login requested by admin
					if(email.equals("admin@syr.edu")) {
						
						session.setAttribute("email",email); // set session atribute for admin
						session.setAttribute("name", name);
						// open admin home page if authentication passed
						request.getRequestDispatcher("AdminHome.jsp").forward(request, response);
					}
					else {
					// driver home page is opened
					session.setAttribute("email",email); // set session for driver
					session.setAttribute("name", name);
					
					request.getRequestDispatcher("DriverHome.jsp").forward(request, response); 
					}
				}
			}
		}
		if("loginotp".equals(action)) {
			// on successful text based authentication student is prompted for otp and that is checked in db if the student entered the correct otp(which was sent on student email id)
			Shuttle s = new Shuttle();
			String email = (String)session.getAttribute("email");
			String otp=request.getParameter("otp");
			System.out.println("controller email"+email);
			String[] data=s.loginOTP(email,otp);
			String name=data[0];
			String address=data[1];
			String waitTime=data[2];
			String timestamp=data[3];
			String count=data[4];
			if(name.equals("1234")) {
				System.out.println("otp authentication failed");
				response.setContentType("text/html"); 
				PrintWriter pw=response.getWriter();
						pw.print("your otp does not match.....try again");// if otp doesnot match provide the error message
			     request.getRequestDispatcher("LoginOTP.jsp").include(request, response);
				
			}
			else { // on successful otp authentication homepage of student is displayed.
				System.out.println("otp authentication success");
				session.setAttribute("email",email);
				session.setAttribute("name",name);
				session.setAttribute("address",address);
				session.setAttribute("waitTime", waitTime);
				session.setAttribute("timestamp", timestamp);
				session.setAttribute("count", count);
				System.out.println("address:"+address);
				request.getRequestDispatcher("Homepage.jsp").forward(request, response); 
				
			}
		}
		if("book".equals(action)) {
			// booking request made by student
			Booking book= new Booking();
			// access setter method of booking.java to set the boooking details
			book.setName(request.getParameter("name"));
			book.setAddress(request.getParameter("address"));
			book.setEmail(request.getParameter("email"));
			book.setDate(request.getParameter("date"));
			Shuttle s = new Shuttle();
			s.createBooking(book); // call the service method to make booking entry in db
			response.setContentType("text/html"); 
			PrintWriter pw=response.getWriter();
					pw.print("Booking done...."); // booking response printed on the screen
		     request.getRequestDispatcher("Book.jsp").include(request, response); 
			
		}
		if("createlist".equals(action)) {
			// Fetching the booking detail by driver to start a trip
			Shuttle s=new Shuttle();
			ArrayList<Booking> b=new ArrayList<Booking>();
			String dname=(String) session.getAttribute("name");
			b=s.createList(dname);
			ArrayList<String> addresses = new ArrayList<String>();

			for(Booking bo:b) {
				addresses.add(bo.getAddress());
			}
			session.setAttribute("addresses", addresses); //addresses are set as session to be accessed by google map for tracking and dropping the students
			session.setAttribute("b", b);
		request.getRequestDispatcher("DriverTripList.jsp").forward(request, response); // driver trip list is opened with drop details of student
			
			
		}
		if("viewbooking".equals(action)) {
			// booking details are accessed by student.
			Shuttle s=new Shuttle();
			String semail=(String) session.getAttribute("email");
			ArrayList<Booking> bl=new ArrayList<Booking>();
			bl=s.viewbooklist(semail);
			request.setAttribute("bl", bl); // last 5  booking details are provided to student on screen
			request.getRequestDispatcher("viewbooklist.jsp").forward(request, response); 
		}
		if("cancel".equals(action)) {
			// if cancellation for a booking is invoked by student that particular booking is cancelled.
			String semail=(String) session.getAttribute("email");
			Shuttle s=new Shuttle();
			s.cancel(semail);
			response.setContentType("text/html"); 
			PrintWriter pw=response.getWriter();
					pw.print("Cancellation Successful");
		     
		}
		
		if("adminview".equals(action)) {
			// admin accesing all the booking details fetched from DB.
		Shuttle s = new Shuttle();
		ArrayList<Booking> newbook = new ArrayList<Booking>();
		newbook = s.viewbookingsadmin();
		request.setAttribute("newbook", newbook);
		request.getRequestDispatcher("Allbookings.jsp").forward(request, response); 
	
		
			
		}
		if("forgotpwd".equals(action)) {
			// password is fetched from db for student and provided to his email id
			String email = (String) request.getParameter("eid");
			Shuttle s = new Shuttle();
			String status = s.forgotPassword(email);
			if (status.equals("fail")) {
				// if student does not exist in db error message is provided
				response.setContentType("text/html"); 
				PrintWriter pw=response.getWriter();
						pw.print("Email id is not registered...Please register first!");
			     request.getRequestDispatcher("forgotpwd.jsp").include(request, response); 
				
			}
			else {
				//if valid email id then message is printed that email id is sent on your email id
				EmailPassword e= new EmailPassword();
				e.sendPassword(email,status);
				response.setContentType("text/html"); 
				PrintWriter pw=response.getWriter();
				pw.print("Password sent to your registered email id");
	     request.getRequestDispatcher("forgotpwd.jsp").include(request, response); 
			}
			
		}
		if("changepwd".equals(action)) {
			// changing the password in DB when requested by student corresponding to his email id
			String pass=(String)request.getParameter("pwd");
			String email=(String) session.getAttribute("email");
			Shuttle s = new Shuttle();
			s.changePassword(email,pass);
			response.setContentType("text/html"); 
			PrintWriter pw=response.getWriter();
			pw.print("Password changed"); // success message is printed on the screen
     request.getRequestDispatcher("ChangePwd.jsp").include(request, response); 
		}
		
	}

}
