package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bean.Alternativa;

public class AlternativaDao {
	private Connection con;

	public void addAlternativa(Alternativa alternativa) {
		try {
			String sql = "INSERT INTO ALTERNATIVA (DESCRICAO, STATUS, QUESTAO) VALUES (?,?,?)";

			this.con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, alternativa.getDescricao());
			stmt.setBoolean(2, alternativa.isCorreta());
			stmt.setLong(3, alternativa.getQuestao());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(con);
		}
	}

	public Alternativa getAlternativa(Long codigo) {

		Alternativa alternativa = new Alternativa();

		try {

			String sql = "SELECT ID, DESCRICAO, STATUS, QUESTAO FROM ALTERNATIVA WHERE ID = ? ";

			this.con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, codigo);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Long id = rs.getLong("id");
				String descricao = rs.getString("descricao");
				boolean status = rs.getBoolean("status");
				Long questao = rs.getLong("questao");
				
				alternativa.setId(id);
				alternativa.setDescricao(descricao);
				alternativa.setCorreta(status);
				alternativa.setQuestao(questao);
				
			}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return alternativa;
		} finally {
			ConnectionFactory.closeConnection(con);
		}

		return alternativa;
	}

	public List<Alternativa> getAllAlternativas() {

		List<Alternativa> alternativas = new ArrayList<Alternativa>();

		try {

			String sql = "SELECT ID, DESCRICAO, STATUS, QUESTAO FROM ALTERNATIVA ORDER BY QUESTAO";

			this.con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Long id = rs.getLong("id");
				String descricao = rs.getString("descricao");
				boolean correta = rs.getBoolean("status");
				Long questao = rs.getLong("questao");

				Alternativa alternativa = new Alternativa(id, descricao, correta, questao);
				alternativas.add(alternativa);
			}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return alternativas;
		} finally {
			ConnectionFactory.closeConnection(con);
		}

		return alternativas;
	}
	
	public List<Alternativa> getAlternativasByQuestao(Long codigo) {

		List<Alternativa> alternativas = new ArrayList<Alternativa>();

		try {

			String sql = "SELECT ID, DESCRICAO, STATUS, QUESTAO FROM ALTERNATIVA WHERE QUESTAO = ? ORDER BY ID";

			this.con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Long id = rs.getLong("id");
				String descricao = rs.getString("descricao");
				boolean correta = rs.getBoolean("status");
				Long questao = rs.getLong("questao");

				Alternativa alternativa = new Alternativa(id, descricao, correta, questao);
				alternativas.add(alternativa);
			}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return alternativas;
		} finally {
			ConnectionFactory.closeConnection(con);
		}

		return alternativas;
	}
	
	public List<Alternativa> getByQuestao(Long codigo) {

		List<Alternativa> alternativas = new ArrayList<Alternativa>();

		try {

			String sql = "SELECT ID, DESCRICAO, STATUS, QUESTAO FROM ALTERNATIVA WHERE QUESTAO = ? ORDER BY ID";

			this.con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, codigo);		
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Long id = rs.getLong("id");
				String descricao = rs.getString("descricao");
				boolean correta = rs.getBoolean("status");
				Long questao = rs.getLong("questao");

				Alternativa alternativa = new Alternativa(id, descricao, correta, questao);
				alternativas.add(alternativa);
			}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return alternativas;
		} finally {
			ConnectionFactory.closeConnection(con);
		}

		return alternativas;
	}
	
	public void updateAssunto(Alternativa alternativa) {

		try {
			String sql = "UPDATE ALTERNATIVA SET DESCRICAO = ?, STATUS = ?, QUESTAO = ? WHERE ID = ? ";

			this.con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, alternativa.getDescricao());
			stmt.setBoolean(2, alternativa.isCorreta());
			stmt.setLong(3, alternativa.getQuestao());
			stmt.setLong(4, alternativa.getId());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con);
		}

	}

	public void deleteAssunto(Alternativa alternativa) {

		try {

			String sql = "DELETE FROM ALTERNATIVA WHERE ID = ? ";

			this.con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, alternativa.getId());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con);
		}

	}
}
