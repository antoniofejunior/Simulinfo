package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bean.Concurso;

public class ConcursoDao {
	private Connection con;

	public void addConcurso(Concurso concurso) {
		try {
			String sql = "INSERT INTO CONCURSO (DESCRICAO, ANO) VALUES (?,?)";

			this.con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, concurso.getDescricao());
			stmt.setInt(2, concurso.getAno());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(con);
		}
	}

	public Concurso getConcurso(Long codigo) {

		Concurso concurso = new Concurso();

		try {

			String sql = "SELECT ID, DESCRICAO, ANO FROM CONCURSO WHERE ID = ? ";

			this.con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, codigo);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Long id = rs.getLong("id");
				String descricao = rs.getString("descricao");
				int ano = rs.getInt("ano");

				concurso.setId(id);
				concurso.setDescricao(descricao);
				concurso.setAno(ano);
				
			}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return concurso;
		} finally {
			ConnectionFactory.closeConnection(con);
		}

		return concurso;
	}

	public List<Concurso> getAllConcursos() {

		List<Concurso> concursos = new ArrayList<Concurso>();

		try {

			String sql = "SELECT ID, DESCRICAO, ANO FROM CONCURSO ORDER BY DESCRICAO";

			this.con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Long id = rs.getLong("id");
				String descricao = rs.getString("descricao");
				int ano = rs.getInt("ano");

				Concurso concurso = new Concurso(id, descricao, ano);
				concursos.add(concurso);
			}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return concursos;
		} finally {
			ConnectionFactory.closeConnection(con);
		}

		return concursos;
	}

	public void updateConcurso(Concurso concurso) {

		try {
			String sql = "UPDATE CONCURSO SET DESCRICAO = ?, ANO = ? WHERE ID = ? ";

			this.con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, concurso.getDescricao());
			stmt.setInt(2, concurso.getAno());
			stmt.setLong(3, concurso.getId());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con);
		}

	}

	public void deleteConcurso(Concurso concurso) {

		try {

			String sql = "DELETE FROM CONCURSO WHERE ID = ? ";

			this.con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, concurso.getId());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con);
		}

	}

}
