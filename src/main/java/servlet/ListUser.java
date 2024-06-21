package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDaoImpl;

@WebServlet({"","/Liste"})
public class ListUser extends HttpServlet {
	
	private static final String VUE_USERS = "/WEB-INF/liste.jsp";
	private UserDaoImpl userdaoimpl = new UserDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("users", userdaoimpl.getAll());
		getServletContext().getRequestDispatcher(VUE_USERS).forward(req, resp);
	}
}
