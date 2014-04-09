package br.com.servlet.alterar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bean.Concurso;
import br.com.dao.ConcursoDao;

/**
 * Servlet implementation class AlterarConcursoServlet
 */
@WebServlet("/AlterarConcursoServlet")
public class AlterarConcursoServlet extends HttpServlet {
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
		Concurso concurso =(Concurso) request.getSession().getAttribute("altconcurso");
		concurso.setDescricao(request.getParameter("descricao"));
		concurso.setAno(Integer.parseInt(request.getParameter("ano")));
		ConcursoDao concursoDao = new ConcursoDao();
		concursoDao.updateConcurso(concurso);
		request.getSession().setAttribute("assuntos", concursoDao.getAllConcursos());
		response.sendRedirect("admin/home.jsp");
	}
}
