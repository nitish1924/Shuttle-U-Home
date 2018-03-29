package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
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
			student.setAddress(request.getParameter("add"));
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
				request.getRequestDispatcher("RegFailure.jsp").forward(request, response);
			}
			else{
				request.setAttribute("studentID", studentID);
				request.getRequestDispatcher("RegSuccess.jsp").include(request, response);
		      }
		 }  
		if("login".equals(action)) {
			Shuttle s=new Shuttle();
			String email=request.getParameter("eid");
			String pwd=request.getParameter("pwd");
			String name=s.login(email,pwd);
			if(name.equals("1234")) {
				System.out.println("authentication failed");
				response.setContentType("text/html"); 
				PrintWriter pw=response.getWriter();
						pw.print("your email id or password is wrong");
			     request.getRequestDispatcher("Login.jsp").include(request, response); 
				
			}
			else {
				System.out.println("authentication success");
				session.setAttribute("name",name);
				response.setContentType("text/html");
				request.getRequestDispatcher("Homepage.jsp").forward(request, response); 
			}
		}
	}

}
