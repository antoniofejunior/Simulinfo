package br.com.servlet.alterar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bean.Usuario;
import br.com.dao.UsuarioDao;

/**
 * Servlet implementation class AlterarUsuarioServlet
 */
@WebServlet("/AlterarUsuarioServlet")
public class AlterarUsuarioServlet extends HttpServlet {
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
		Usuario user = (Usuario) request.getSession().getAttribute("usuario");
		user.setNome(request.getParameter("nome"));
		if(!request.getParameter("senha").equals(""))
			user.setSenha(request.getParameter("senha"));
		UsuarioDao userDao = new UsuarioDao();
		userDao.updateUsuario(user);
		request.getSession().setAttribute("usuario", user);
	}

}
