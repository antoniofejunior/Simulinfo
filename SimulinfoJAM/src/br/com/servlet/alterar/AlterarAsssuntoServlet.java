package br.com.servlet.alterar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bean.Assunto;
import br.com.dao.AssuntoDao;

/**
 * Servlet implementation class AlterarAsssuntoServlet
 */
@WebServlet("/AlterarAsssuntoServlet")
public class AlterarAsssuntoServlet extends HttpServlet {
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
		Assunto assunto =(Assunto) request.getSession().getAttribute("altAssunto");
		assunto.setDescricao(request.getParameter("descricao"));
		AssuntoDao assuntoDao = new AssuntoDao();
		assuntoDao.updateAssunto(assunto);
		request.getSession().setAttribute("assuntos", assuntoDao.getAllAssuntos());
		response.sendRedirect("admin/home.jsp");
	}

}
