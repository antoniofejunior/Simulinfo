package br.com.servlet.remover;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dao.AssuntoDao;

/**
 * Servlet implementation class removerAssuntoSevlet
 */
@WebServlet("/RemoverAssuntoSevlet")
public class RemoverAssuntoSevlet extends HttpServlet {
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
		Long idAssunto =(Long) request.getSession().getAttribute("altAssunto");
		AssuntoDao assuntoDao = new AssuntoDao();
		assuntoDao.deleteAssunto(assuntoDao.getAssunto(idAssunto));
		request.getSession().setAttribute("assuntos",assuntoDao.getAllAssuntos());
		response.sendRedirect("admin/home.jsp");
	}

}
