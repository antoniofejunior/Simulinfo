package br.com.servlet.cadastro;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bean.Usuario;
import br.com.dao.UsuarioDao;

/**
 * Servlet implementation class CadastrarUsuarioServlet
 */
@WebServlet("/CadastrarUsuarioServlet")
public class CadastrarUsuarioServlet extends HttpServlet {
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
		String login = request.getParameter("logincd");
		String nome = request.getParameter("nomecd");
		String senha = request.getParameter("senhacd");
		UsuarioDao usuarioDao = new UsuarioDao();
		usuarioDao.addUsuario(new Usuario(login, nome, senha));
		request.getSession().setAttribute("usuario", usuarioDao.getByLogin(login));
		response.sendRedirect("home.jsp");
	}

}
