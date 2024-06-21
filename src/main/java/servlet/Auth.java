package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Utilisateur;
import dao.UtilisateurDAO;
import forms.LoginForm;

/**
 * Servlet implementation class Auth
 */
@WebServlet({"/Auth", "/Logout"})
public class Auth extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_CONN = "/WEB-INF/connect.jsp";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Auth() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		if(path.equals("/Logout")) {
			HttpSession session = request.getSession();
			session.invalidate();
			
		}
		getServletContext().getRequestDispatcher(VUE_CONN).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginForm form = new LoginForm(request);
		form.login();
		if(form.getStatus()) {
			response.sendRedirect("Liste");
		}else {
			request.setAttribute("form", form);
			request.setAttribute("user", form.getUser());
			request.setAttribute("status", form.getStatusMessage());
			doGet(request,response);
		}
	}

}
