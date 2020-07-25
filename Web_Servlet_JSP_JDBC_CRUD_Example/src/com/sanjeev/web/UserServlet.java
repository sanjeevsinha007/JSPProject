package com.sanjeev.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sanjeev.dao.UserDAO;
import com.sanjeev.model.User;

@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO userDAO;
   
    public UserServlet() {
        super();
        userDAO=new UserDAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getServletPath();
		try {
			switch(action) {
			
			case "/newuser":
				userADD(request,response);
				break;
				
			case "/userform":
				userForm(request,response);
				break;
				
			case "/deleteuser":
				deleteUser(request,response);
				break;
				
			case "/editform":
				editForm(request,response);
				break;
			
			case "/edituser":
				editUser(request,response);
				break;
				
			case "/list":
				userList(request,response);
				break;
				
			case "/loginuser":
				loginUser(request,response);
				break;
				
			case "/loginForm":
				loginUser(request,response);
				break;
			
			case "/":
				loginForm(request,response);
				break;
				
			case "/LogoutServlet":
				logoutUser(request,response);
				break;
				
			default:
				//loginForm(request,response);
				userList(request,response);
				
			}
		}catch(Exception ex)
		{
			System.out.println("Exception Caught");
			System.out.println(ex.getMessage());
		}
	}

	
	private void logoutUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer=response.getWriter();
		HttpSession session=request.getSession(true);
		if(session!=null)
		{
			RequestDispatcher rd=request.getRequestDispatcher("login-form.jsp");
			rd.forward(request, response);
//			session.removeAttribute("username");
			session.invalidate();
			
//			request.getRequestDispatcher("Login.html").include(request, response);
//			writer.println("<h3>You are successfully logged out</h3>");
		}
		else
		{
			writer.println("Session not exists");
		}
	}

	


	private void loginUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		RequestDispatcher rd=null;
		
		String email=request.getParameter("email");
		String password=request.getParameter("pass");
		PrintWriter writer=response.getWriter();
		if(email.equalsIgnoreCase("admin@admin.com") && password.equals("admin"))
		{
			HttpSession session=request.getSession();
			session.setAttribute("email", email);
			List<User> userList=userDAO.selectAllUser();
			request.setAttribute("listUser", userList);
			System.out.println("User List are : " + userList);
			rd=request.getRequestDispatcher("user-list.jsp");
			rd.forward(request, response);
			
		}else {
			email=null;
			HttpSession session=request.getSession();
			session.setAttribute("email", email);
			rd=request.getRequestDispatcher("login-form.jsp");
			rd.forward(request, response);
			//response.setContentType("text/html");
			//writer.println("<h3 style='color:red;'> Invalid Credentials..</h3>");
		}
		// TODO Auto-generated method stub
		
	}


	private void loginForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("login-form.jsp");
		rd.forward(request, response);
		
	}


	private void editForm(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		User existingUser=userDAO.selectUser(id);
		//RequestDispatcher rd=request.getRequestDispatcher("edit-form.jsp");
		RequestDispatcher rd=request.getRequestDispatcher("user-form2.jsp");
		request.setAttribute("user", existingUser);
		HttpSession session=request.getSession();
		session.setAttribute("userid", existingUser.getId());
		rd.forward(request, response);
		
	}


	private void userForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//RequestDispatcher rd=request.getRequestDispatcher("user-form.jsp");
		RequestDispatcher rd=request.getRequestDispatcher("user-form2.jsp");
		rd.forward(request, response);
		
	}


	private void editUser(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
		HttpSession session=request.getSession(true);
		int id=(int) session.getAttribute("userid");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String country=request.getParameter("country");
		User modifiedUser=new User(id,name,email,country);
		userDAO.updateUser(modifiedUser);
		response.sendRedirect("list");
		System.out.println("Edit User");
		
	}


	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		if(userDAO.deleteUser(id))
		{
			response.sendRedirect("l");
		}
		else {
			System.out.println("There is some error in deleteing user");
		}
		System.out.println("Delete User");
		
	}


	private void userList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
		List<User> userList=userDAO.selectAllUser();
		request.setAttribute("listUser", userList);
		System.out.println("User List are : " + userList);
		
		RequestDispatcher rd=request.getRequestDispatcher("user-list.jsp");
		rd.forward(request,response);
		
	}


	private void userADD(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String country=request.getParameter("country");
		User newuser=new User(name,email,country);
		userDAO.insertUser(newuser);
		response.sendRedirect("list");
		System.out.println("New User");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
