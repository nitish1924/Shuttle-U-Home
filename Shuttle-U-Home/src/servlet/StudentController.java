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
		String action=request.getParameter("action");
		HttpSession session=request.getSession();
		if("addStudent".equals(action))
		{
			Student student= new Student();
			
			student.setName(request.getParameter("studentName"));
			student.setGender(request.getParameter("sex"));
			student.setAddress(request.getParameter("add")+" Syracuse");
			student.setEmailId(request.getParameter("eid"));
			student.setPhoneNo(Long.parseLong(request.getParameter("phone")));
			student.setPassword(request.getParameter("pwd"));
			
		
			Shuttle shuttle= new Shuttle ();
			int studentID = 0;
			try {
				studentID = shuttle.createStudent(student);
				System.out.println(studentID);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(studentID==0){
				response.setContentType("text/html"); 
				PrintWriter pw=response.getWriter();
						pw.print("Email id already registered!!Register using different email id");
			     request.getRequestDispatcher("Registration.jsp").include(request, response); 
			}
			else{
				response.setContentType("text/html"); 
				PrintWriter pw=response.getWriter();
						pw.print("Registered Successfully!Please Login");
			     request.getRequestDispatcher("Login.jsp").include(request, response); 
		      }
		 }  
		if("addEmployee".equals(action))
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
				response.setContentType("text/html"); 
				PrintWriter pw=response.getWriter();
						pw.print("Email id already registered!!Register using different email id");
			     request.getRequestDispatcher("EmployeeRegister.jsp").include(request, response); 
			}
			else{
				response.setContentType("text/html"); 
				PrintWriter pw=response.getWriter();
						pw.print("Employee Registered Successfully!");
			     request.getRequestDispatcher("AdminHome.jsp").include(request, response); 
		      }
		 }  
		if("login".equals(action)) {
			Shuttle s=new Shuttle();
			String email=request.getParameter("seid");
			String pwd=request.getParameter("spwd");
			String identity =request.getParameter("identity");
			
			if(identity.equals("Student")) {
				
			String name=s.login(email,pwd);
			if(name.equals("1234")) {
				System.out.println("authentication failed");
				response.setContentType("text/html"); 
				PrintWriter pw=response.getWriter();
						pw.print("your email id or password is wrong.....try again");
			     request.getRequestDispatcher("Login.jsp").include(request, response); 
				
			}
			else {
				System.out.println("text authentication success");
				EmailOTP e= new EmailOTP();
				e.createotp(email);
				session.setAttribute("email",email);
				
				request.getRequestDispatcher("LoginOTP.jsp").forward(request, response); 
			}
			}
			else {
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
					if(email.equals("admin@syr.edu")) {
						
						session.setAttribute("email",email);
						session.setAttribute("name", name);
						
						request.getRequestDispatcher("AdminHome.jsp").forward(request, response);
					}
					else {
					
					session.setAttribute("email",email);
					session.setAttribute("name", name);
					
					request.getRequestDispatcher("DriverHome.jsp").forward(request, response); 
					}
				}
			}
		}
		if("book".equals(action)) {
			Booking book= new Booking();
			
			book.setName(request.getParameter("name"));
			book.setAddress(request.getParameter("address"));
			book.setEmail(request.getParameter("email"));
			book.setDate(request.getParameter("date"));
			Shuttle s = new Shuttle();
			s.createBooking(book);
			response.setContentType("text/html"); 
			PrintWriter pw=response.getWriter();
					pw.print("Booking done....view your booking list");
		     request.getRequestDispatcher("Homepage.jsp").include(request, response); 
			
		}
		if("createlist".equals(action)) {
			Shuttle s=new Shuttle();
			ArrayList<Booking> b=new ArrayList<Booking>();
			String dname=(String) session.getAttribute("name");
			b=s.createList(dname);
			ArrayList<String> addresses = new ArrayList<String>();

			for(Booking bo:b) {
				addresses.add(bo.getAddress());
			}
			session.setAttribute("addresses", addresses);
			session.setAttribute("b", b);
		request.getRequestDispatcher("DriverTripList.jsp").forward(request, response); 
			
			
		}
		if("viewbooking".equals(action)) {
			Shuttle s=new Shuttle();
			String semail=(String) session.getAttribute("email");
			ArrayList<Booking> bl=new ArrayList<Booking>();
			bl=s.viewbooklist(semail);
			request.setAttribute("bl", bl);
			request.getRequestDispatcher("viewbooklist.jsp").forward(request, response); 
		}
		if("cancel".equals(action)) {
			String semail=(String) session.getAttribute("email");
			Shuttle s=new Shuttle();
			s.cancel(semail);
			response.setContentType("text/html"); 
			PrintWriter pw=response.getWriter();
					pw.print("Cancellation Successful");
		     request.getRequestDispatcher("Homepage.jsp").include(request, response);
		}
		
		if("adminview".equals(action)) {
			
		Shuttle s = new Shuttle();
		ArrayList<Booking> newbook = new ArrayList<Booking>();
		newbook = s.viewbookingsadmin();
		request.setAttribute("newbook", newbook);
		request.getRequestDispatcher("Allbookings.jsp").forward(request, response); 
	
		
			
		}
		if("loginotp".equals(action)) {
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
						pw.print("your otp does not match.....try again");
			     request.getRequestDispatcher("LoginOTP.jsp").include(request, response); 
				
			}
			else {
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
	}

}
