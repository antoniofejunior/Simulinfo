package br.com.servlet.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bean.Usuario;
import br.com.dao.AssuntoDao;
import br.com.dao.ConcursoDao;
import br.com.dao.UsuarioDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginUsuarioServlet")
public class LoginUsuarioServlet extends HttpServlet {
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
		
		UsuarioDao userDao = new UsuarioDao();
		try{
		Usuario user = userDao.getByLogin(login);
		
		if(user.getSenha().equals(senha)){
			request.getSession().setAttribute("usuario", user);
			ConcursoDao concursoDao = new ConcursoDao();
			AssuntoDao assuntoDao = new AssuntoDao();
			request.getSession().setAttribute("concursos", concursoDao.getAllConcursos());
			request.getSession().setAttribute("assuntos", assuntoDao.getAllAssuntos());
			response.sendRedirect("home.jsp");
			
		} else
			response.sendRedirect("index.html");	
		}catch(NullPointerException e){
			e.printStackTrace();
			response.sendRedirect("index.html");
		}
	}

}
