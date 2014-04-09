package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bean.Assunto;

public class AssuntoDao {
	private Connection con;

	public void addAssunto(Assunto assunto) {
		try {
			String sql = "INSERT INTO ASSUNTO (DESCRICAO) VALUES (?)";

			this.con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, assunto.getDescricao());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(con);
		}
	}

	public Assunto getAssunto(Long codigo) {

		Assunto assunto = new Assunto();

		try {

			String sql = "SELECT ID, DESCRICAO FROM ASSUNTO WHERE ID = ? ";

			this.con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, codigo);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Long id = rs.getLong("id");
				String descricao = rs.getString("descricao");
				
				assunto.setId(id);
				assunto.setDescricao(descricao);
				
			}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return assunto;
		} finally {
			ConnectionFactory.closeConnection(con);
		}

		return assunto;
	}

	public List<Assunto> getAllAssuntos() {

		List<Assunto> assuntos = new ArrayList<Assunto>();

		try {

			String sql = "SELECT ID, DESCRICAO FROM ASSUNTO ORDER BY DESCRICAO";

			this.con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Long id = rs.getLong("id");
				String descricao = rs.getString("descricao");

				Assunto assunto = new Assunto(id, descricao);
				assuntos.add(assunto);
			}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return assuntos;
		} finally {
			ConnectionFactory.closeConnection(con);
		}

		return assuntos;
	}

	public void updateAssunto(Assunto assunto) {

		try {
			String sql = "UPDATE ASSUNTO SET DESCRICAO = ? WHERE ID = ? ";

			this.con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, assunto.getDescricao());
			stmt.setLong(2, assunto.getId());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con);
		}

	}

	public void deleteAssunto(Assunto assunto) {

		try {

			String sql = "DELETE FROM ASSUNTO WHERE ID = ? ";

			this.con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, assunto.getId());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con);
		}

	}
}
