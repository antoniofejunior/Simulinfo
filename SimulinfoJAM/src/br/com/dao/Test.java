package br.com.dao;

import br.com.bean.Admin;

public class Test {
	public static void main(String[] args) {
		
		AdminDao adminDao = new AdminDao();
//		
		Admin admin1 = new Admin("marciel", "Marciel", "12345");
//		
		adminDao.addAdmin(admin1);
		System.out.println("ADmin Cadastrado");
//		
//		UsuarioDao usuarioDao = new UsuarioDao();
//		
//		Usuario usuario1 = new Usuario("antonio", "Antonio", "123");
//
//		usuarioDao.addUsuario(usuario1);
//
//		ConcursoDao concursoDao = new ConcursoDao();
//		
//		Concurso concurso1 = new Concurso("Concurso IFPB", 2000);
//		
//		concursoDao.addConcurso(concurso1);
//
//		AssuntoDao assuntoDao = new AssuntoDao();
//		
//		Assunto assunto1 = new Assunto("Redes");
//		
//		assuntoDao.addAssunto(assunto1);
//		
//		ResultadoDao resultadoDao = new ResultadoDao();
//		
//		usuario1 = usuarioDao.getByLogin("antonio");
//		assunto1 = assuntoDao.getAssunto((long) 1);
//		Resultado resultado = new Resultado(usuario1, 123, assunto1);
//		
//		resultadoDao.addResultado(resultado);
//		
//		
//		concurso1 = concursoDao.getConcurso((long) 1);
//		admin1 = adminDao.getByLogin("marciel");
//		QuestaoDao questaoDao = new QuestaoDao();
//		
//		Questao questao = new Questao("Que dia eh hoje", assunto1, concurso1, admin1);
//		
//		questaoDao.addQuestao(questao);
//		
//		AlternativaDao alternativaDao = new AlternativaDao();
//		
//		Alternativa alternativa1 = new Alternativa("dia 1", false, (long) 1);
//		Alternativa alternativa2 = new Alternativa("dia 7", true, (long) 1);
//		Alternativa alternativa3 = new Alternativa("dia 5", false, (long) 1);
//		
//		alternativaDao.addAlternativa(alternativa1);
//		alternativaDao.addAlternativa(alternativa2);
//		alternativaDao.addAlternativa(alternativa3);
//		
//		questao.addAlternativa(alternativa1);
//		questao.addAlternativa(alternativa2);
//		questao.addAlternativa(alternativa3);
//		
//		QuestaoDao questaoDao = new QuestaoDao();
//		
//		Questao questao = questaoDao.getQuestao((long) 1);
//		
//		Alternativa alternativa = questao.getAlternativas().get(0);
//		
//		alternativa.setDescricao("dia 0000");
//		
//		alternativaDao.updateAssunto(alternativa);
//		
//		System.out.println(questao.getDescricao());
//		System.out.println();
//		System.out.println();
//		System.out.println();
	}
}
