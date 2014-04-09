package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bean.Admin;

public class AdminDao {
	private Connection con;

	public void addAdmin(Admin admin) {
		try {
			String sql = "INSERT INTO ADMIN (LOGIN, NOME, SENHA, STATUS) VALUES (?,?,?,?)";

			this.con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, admin.getLogin());
			stmt.setString(2, admin.getNome());
			stmt.setString(3, admin.getSenha());
			stmt.setBoolean(4, admin.getStatus());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(con);
		}
	}

	public Admin getByLogin(String codigo) {

		Admin admin = new Admin();

		try {

			String sql = "SELECT ID, LOGIN, NOME, SENHA FROM ADMIN WHERE LOGIN = ? ";

			this.con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, codigo);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Long id = rs.getLong("id");
				String login = rs.getString("login");
				String nome = rs.getString("nome");
				String senha = rs.getString("senha");

				admin.setId(id);
				admin.setLogin(login);
				admin.setNome(nome);
				admin.setSenha(senha);
			}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return admin;
		} finally {
			ConnectionFactory.closeConnection(con);
		}

		return admin;
	}
	
	public Admin getById(Long codigo) {

		Admin admin = new Admin();

		try {

			String sql = "SELECT ID, LOGIN, NOME, SENHA FROM ADMIN WHERE ID = ? ";

			this.con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, codigo);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Long id = rs.getLong("id");
				String login = rs.getString("login");
				String nome = rs.getString("nome");
				String senha = rs.getString("senha");

				admin.setId(id);
				admin.setLogin(login);
				admin.setNome(nome);
				admin.setSenha(senha);
			}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return admin;
		} finally {
			ConnectionFactory.closeConnection(con);
		}

		return admin;
	}

	public List<Admin> getAllAdmin() {

		List<Admin> administradores = new ArrayList<Admin>();

		try {

			String sql = "SELECT ID, LOGIN, NOME, SENHA FROM ADMIN WHERE STATUS ORDER BY NOME";

			this.con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Long id = rs.getLong("id");
				String login = rs.getString("login");
				String nome = rs.getString("nome");
				String senha = rs.getString("senha");

				Admin admin = new Admin(id, login, nome, senha);
				administradores.add(admin);
			}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return administradores;
		} finally {
			ConnectionFactory.closeConnection(con);
		}

		return administradores;
	}

	public void updateAdmin(Admin admin) {

		try {
			String sql = "UPDATE ADMIN SET LOGIN = ?, NOME = ?, SENHA = ? WHERE ID = ? ";

			this.con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, admin.getLogin());
			stmt.setString(2, admin.getNome());
			stmt.setString(3, admin.getSenha());
			stmt.setLong(4, admin.getId());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con);
		}

	}
	
	public void deleteByLogin (String codigo) {
		
		try {
			
			String sql = "UPDATE ADMIN SET STATUS = FALSE WHERE LOGIN = ? ";
			
			this.con  = ConnectionFactory.getConnection();
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, codigo);
			
			stmt.execute();
			stmt.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con);
		}

	}

}