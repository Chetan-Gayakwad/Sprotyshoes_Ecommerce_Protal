package com.simplilearn.sportyshoes.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simplilearn.sportyshoes.helper.FactoryProvider;
import com.smplilearn.sportyshoes.Dao.UserDao;
import com.smplilearn.sportyshoes.entities.User;


public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public loginServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserDao dao = new UserDao(FactoryProvider.getFactory());
		User user = dao.getUserByemailAndpassword(email, password);
		HttpSession httpSession = request.getSession();
		//System.out.println(user);
		
		if (user==null)
		{
			httpSession.setAttribute("message", " Invalid Details email or password worng ");
			response.sendRedirect("login.jsp");
			return;
			
		}else {
			out.println("<h2>Welcome "+ user.getUnerName()+"<h2>");
			
			httpSession.setAttribute("current-user", user);
			
			if(user.getUserType().equals("admin")) {
				
				response.sendRedirect("admin.jsp");
				
			}else if(user.getUserType().equals("normal")) 
			{
				response.sendRedirect("normal.jsp");
			}else {
				out.println("<h2>We have not identify user type<h2>");
			}
			
		}
		
		
		
	}

}
