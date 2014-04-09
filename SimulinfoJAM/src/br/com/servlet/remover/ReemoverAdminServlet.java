package br.com.servlet.remover;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bean.Admin;
import br.com.dao.AdminDao;

/**
 * Servlet implementation class ReemoverAdminServlet
 */
@WebServlet("/ReemoverAdminServlet")
public class ReemoverAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminDao adminDao= new AdminDao();
		Admin user = (Admin) request.getSession().getAttribute("usuario");
		adminDao.deleteByLogin(user.getLogin());
	}

}
