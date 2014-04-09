package br.com.servlet.buscar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dao.ConcursoDao;

/**
 * Servlet implementation class BuscarCuncursoServlet
 */
@WebServlet("/BuscarCuncursoServlet")
public class BuscarCuncursoServlet extends HttpServlet {
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
		Long idConcurso = Long.parseLong(request.getParameter("concurso"));
		ConcursoDao concursoDao = new ConcursoDao();
		request.getSession().setAttribute("altConcurso", concursoDao.getConcurso(idConcurso));
		response.sendRedirect("AlterarDadoConcurso.jsp");
	}

}
