package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDaoImpl;
import forms.ModifyUserForm;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/update")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userdaoimpl = new UserDaoImpl(); 
	private static final String VUE_MODIFY_USER = "/WEB-INF/modifyUser.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.valueOf(req.getParameter("id"));

		req.setAttribute("user", userdaoimpl.get(id));
		
		getServletContext().getRequestDispatcher(VUE_MODIFY_USER).forward(req, resp);
	}
	
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			int id =  Integer.valueOf(req.getParameter("id"));
			ModifyUserForm form = new ModifyUserForm(req);
			if(form.modifier(id)) {
				resp.sendRedirect("Liste");
			}else {
			req.setAttribute("form", form);
			req.setAttribute("user", form.getUser());
			req.setAttribute("status", form.getStatus());
			req.setAttribute("statusMessage", form.getStatusMessage());
			req.setAttribute("erreurs", form.getErreurs());
			
			
				req.getServletContext().getRequestDispatcher(VUE_MODIFY_USER).forward(req, resp);
			
			}
		}


}
