package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Utilisateur;
import dao.UtilisateurDAO;
import forms.AddUserForm;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String VUE_ADD_USERS = "/WEB-INF/addUser.jsp";

    public AddUser() { }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		getServletContext().getRequestDispatcher(VUE_ADD_USERS).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AddUserForm form = new AddUserForm(request);
		if(form.ajouter()) {
			response.sendRedirect("Liste");
		}else {
		request.setAttribute("form", form);
		request.setAttribute("user", form.getUser());
		request.setAttribute("status", form.getStatus());
		request.setAttribute("statusMessage", form.getStatusMessage());
		request.setAttribute("erreurs", form.getErreurs());
		
		
			request.getServletContext().getRequestDispatcher(VUE_ADD_USERS).forward(request, response);
		
		}
			
		
		

	}

}
