package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bean.Admin;
import br.com.bean.Alternativa;
import br.com.bean.Assunto;
import br.com.bean.Concurso;
import br.com.bean.Questao;

public class QuestaoDao {
	private Connection con;

	public void addQuestao(Questao questao) {
		try {
			String sql = "INSERT INTO QUESTAO (DESCRICAO, DATA, ASSUNTO, CONCURSO, ADMIN) VALUES (?,?,?,?,?)";

			this.con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, questao.getDescricao());
			stmt.setString(2, questao.getData());
			stmt.setLong(3, questao.getAssunto().getId());
			stmt.setLong(4, questao.getConcurso().getId());
			stmt.setLong(5, questao.getAdmin().getId());
			
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(con);
		}
	}

	public Questao getQuestao(Long codigo) {
		
		Questao questoes = new Questao();

		try {
			
			AlternativaDao alternativaDao = new AlternativaDao();
			AssuntoDao assuntoDao = new AssuntoDao();
			ConcursoDao concursoDao = new ConcursoDao();
			AdminDao adminDao = new AdminDao();

			String sql = "SELECT ID, DESCRICAO, DATA, ASSUNTO, CONCURSO, ADMIN FROM QUESTAO WHERE ID = ? ";

			this.con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, codigo);

			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Long id = rs.getLong("id");
				String descricao = rs.getString("descricao");
				String data = rs.getString("data");
				
				Long assunto = rs.getLong("assunto");
				Assunto a = assuntoDao.getAssunto(assunto);
				
				Long concurso = rs.getLong("concurso");
				Concurso c = concursoDao.getConcurso(concurso);
				
				Long admin = rs.getLong("admin");
				Admin adm = adminDao.getById(admin);
				
				List<Alternativa> alternativas = alternativaDao.getByQuestao(id);
				
				questoes.setId(id);
				questoes.setDescricao(descricao);
				questoes.setData(data);
				questoes.setAssunto(a);
				questoes.setConcurso(c);
				questoes.setAdmin(adm);
				questoes.setAlternativas(alternativas);

			}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return questoes;
		} finally {
			ConnectionFactory.closeConnection(con);
		}

		return questoes;
	}
	

	public List<Questao> getAllQuestoes() {

		List<Questao> questoes = new ArrayList<Questao>();

		try {
		
			AlternativaDao alternativaDao = new AlternativaDao();
			AssuntoDao assuntoDao = new AssuntoDao();
			ConcursoDao concursoDao = new ConcursoDao();
			AdminDao adminDao = new AdminDao();

			String sql = "SELECT ID, DESCRICAO, DATA, ASSUNTO, CONCURSO, ADMIN FROM QUESTAO ORDER BY ASSUNTO";
			
			this.con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Long id = rs.getLong("id");
				String descricao = rs.getString("descricao");
				String data = rs.getString("data");
				
				Long assunto = rs.getLong("assunto");
				Assunto a = assuntoDao.getAssunto(assunto);
				
				Long concurso = rs.getLong("concurso");
				Concurso c = concursoDao.getConcurso(concurso);
				
				Long admin = rs.getLong("admin");
				Admin adm = adminDao.getById(admin);
				
				List<Alternativa> alternativas = alternativaDao.getByQuestao(id);

				Questao questao = new Questao(id, descricao, data, a, c, adm, alternativas);
				questoes.add(questao);
			}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return questoes;
		} finally {
			ConnectionFactory.closeConnection(con);
		}

		return questoes;
	}
	
	public List<Questao> getSimulado() {

		List<Questao> questoes = new ArrayList<Questao>();

		try {
		
			AlternativaDao alternativaDao = new AlternativaDao();
			AssuntoDao assuntoDao = new AssuntoDao();
			ConcursoDao concursoDao = new ConcursoDao();
			AdminDao adminDao = new AdminDao();

			String sql = "SELECT ID, DESCRICAO, DATA, ASSUNTO, CONCURSO, ADMIN FROM QUESTAO ORDER BY RANDOM() LIMIT 15";
			
			this.con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Long id = rs.getLong("id");
				String descricao = rs.getString("descricao");
				String data = rs.getString("data");
				
				Long assunto = rs.getLong("assunto");
				Assunto a = assuntoDao.getAssunto(assunto);
				
				Long concurso = rs.getLong("concurso");
				Concurso c = concursoDao.getConcurso(concurso);
				
				Long admin = rs.getLong("admin");
				Admin adm = adminDao.getById(admin);
				
				List<Alternativa> alternativas = alternativaDao.getByQuestao(id);

				Questao questao = new Questao(id, descricao, data, a, c, adm, alternativas);
				questoes.add(questao);
			}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return questoes;
		} finally {
			ConnectionFactory.closeConnection(con);
		}

		return questoes;
	}
	
	public List<Questao> getSimuladoByAssunto(Long codigo) {

		List<Questao> questoes = new ArrayList<Questao>();

		try {
		
			AlternativaDao alternativaDao = new AlternativaDao();
			AssuntoDao assuntoDao = new AssuntoDao();
			ConcursoDao concursoDao = new ConcursoDao();
			AdminDao adminDao = new AdminDao();

			String sql = "SELECT ID, DESCRICAO, DATA, ASSUNTO, CONCURSO, ADMIN FROM QUESTAO WHERE ASSUNTO = ? ORDER BY RANDOM() LIMIT 15";
			
			this.con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, codigo);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Long id = rs.getLong("id");
				String descricao = rs.getString("descricao");
				String data = rs.getString("data");
				
				Long assunto = rs.getLong("assunto");
				Assunto a = assuntoDao.getAssunto(assunto);
				
				Long concurso = rs.getLong("concurso");
				Concurso c = concursoDao.getConcurso(concurso);
				
				Long admin = rs.getLong("admin");
				Admin adm = adminDao.getById(admin);
				
				List<Alternativa> alternativas = alternativaDao.getByQuestao(id);

				Questao questao = new Questao(id, descricao, data, a, c, adm, alternativas);
				questoes.add(questao);
			}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return questoes;
		} finally {
			ConnectionFactory.closeConnection(con);
		}

		return questoes;
	}

	public void updateQuestao(Questao questao) {

		try {
			String sql = "UPDATE QUESTAO SET DESCRICAO = ?, DATA = ?, ASSUNTO = ?, CONCURSO = ?, ADMIN = ? WHERE ID = ? ";

			this.con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, questao.getDescricao());
			stmt.setString(2, questao.getData());
			stmt.setLong(3, questao.getAssunto().getId());
			stmt.setLong(4, questao.getConcurso().getId());
			stmt.setLong(5, questao.getAdmin().getId());
			stmt.setLong(6, questao.getId());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con);
		}

	}

	public void deleteQuestao(Questao questao) {

		try {

			String sql = "DELETE FROM QUESTAO WHERE ID = ? ";

			this.con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, questao.getId());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con);
		}

	}
}
