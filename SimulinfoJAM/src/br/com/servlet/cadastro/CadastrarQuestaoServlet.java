package br.com.servlet.cadastro;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bean.Admin;
import br.com.bean.Questao;
import br.com.dao.AssuntoDao;
import br.com.dao.ConcursoDao;
import br.com.dao.QuestaoDao;

/**
 * Servlet implementation class CadastrarQuestaoServlet
 */
@WebServlet("/CadastrarQuestaoServlet")
public class CadastrarQuestaoServlet extends HttpServlet {
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
		Long idAssunto = Long.parseLong(request.getParameter("assunto"));
		String descricao = request.getParameter("descricao");
		ConcursoDao concurso = new ConcursoDao();
		AssuntoDao assunto = new AssuntoDao();
		Admin admin =(Admin) request.getSession().getAttribute("usuario");
		QuestaoDao questaoDao = new QuestaoDao();
		questaoDao.addQuestao(new Questao(descricao, assunto.getAssunto(idAssunto), concurso.getConcurso(idConcurso), admin));
	}

}
