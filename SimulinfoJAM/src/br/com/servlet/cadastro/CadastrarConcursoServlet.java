package br.com.servlet.cadastro;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bean.Concurso;
import br.com.dao.ConcursoDao;

/**
 * Servlet implementation class CadastrarConcursoServlet
 */
@WebServlet("/CadastrarConcursoServlet")
public class CadastrarConcursoServlet extends HttpServlet {
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
		ConcursoDao concursoDao = new ConcursoDao();
		String descricao = request.getParameter("descricao");
		int ano = Integer.parseInt(request.getParameter("ano"));
		concursoDao.addConcurso(new Concurso(descricao, ano));
		request.getSession().setAttribute("concursos", concursoDao.getAllConcursos());
		response.sendRedirect("admin/CadastrarQuestao.jsp");
	}

}
