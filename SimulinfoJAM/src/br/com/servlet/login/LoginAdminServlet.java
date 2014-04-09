package br.com.servlet.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bean.Admin;
import br.com.dao.AdminDao;
import br.com.dao.AssuntoDao;
import br.com.dao.ConcursoDao;

/**
 * Servlet implementation class LoginAdminServlet
 */
@WebServlet("/LoginAdminServlet")
public class LoginAdminServlet extends HttpServlet {

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
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		AdminDao userDao = new AdminDao();
		try{
		Admin user = userDao.getByLogin(login);
		
		if(user.getSenha().equals(senha)){
			request.getSession().setAttribute("usuario", user);
			ConcursoDao concursoDao = new ConcursoDao();
			AssuntoDao assuntoDao = new AssuntoDao();
			request.getSession().setAttribute("concursos", concursoDao.getAllConcursos());
			request.getSession().setAttribute("assuntos", assuntoDao.getAllAssuntos());
			response.sendRedirect("admin/adminHome.jsp");
		}else
			response.sendRedirect("admin/index.html");
		}catch(NullPointerException e){
			e.printStackTrace();
			response.sendRedirect("admin/index.html");
		}
	}

}
