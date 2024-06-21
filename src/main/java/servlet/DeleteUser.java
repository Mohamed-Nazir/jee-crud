package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDaoImpl;

@WebServlet("/delete")
public class DeleteUser extends HttpServlet {

	
	private static final long serialVersionUID = 42947493594993758L;
	private UserDaoImpl userdaoimpl = new UserDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.valueOf(req.getParameter("id"));
		userdaoimpl.delete(id);
		
		resp.sendRedirect("Liste");
	}
}
