package br.com.servlet.cadastro;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bean.Assunto;
import br.com.dao.AssuntoDao;

/**
 * Servlet implementation class CadastrarAssuntoServlet
 */
@WebServlet("/CadastrarAssuntoServlet")
public class CadastrarAssuntoServlet extends HttpServlet {
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
		AssuntoDao assuntoDao= new AssuntoDao();
		assuntoDao.addAssunto(new Assunto(request.getParameter("descricao")));
		request.getSession().setAttribute("assuntos", assuntoDao.getAllAssuntos());
		response.sendRedirect("admin/CadastrarQuestao.jsp");
	}

}
