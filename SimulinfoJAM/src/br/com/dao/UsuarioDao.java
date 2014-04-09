package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bean.Usuario;

public class UsuarioDao {
	private Connection con;

	public void addUsuario(Usuario usuario) {
		try {
			String sql = "INSERT INTO USUARIO (LOGIN, NOME, SENHA) VALUES (?,?,?)";

			this.con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getNome());
			stmt.setString(3, usuario.getSenha());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(con);
		}
	}
	
	public Usuario getById(Long codigo) {

		Usuario usuario = new Usuario();

		try {

			String sql = "SELECT ID, LOGIN, NOME, SENHA FROM USUARIO WHERE ID = ? ";

			this.con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, codigo);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Long id = rs.getLong("id");
				String login = rs.getString("login");
				String nome = rs.getString("nome");
				String senha = rs.getString("senha");

				usuario.setId(id);
				usuario.setLogin(login);
				usuario.setNome(nome);
				usuario.setSenha(senha);
			}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return usuario;
		} finally {
			ConnectionFactory.closeConnection(con);
		}

		return usuario;
	}

	public Usuario getByLogin(String codigo) {

		Usuario usuario = new Usuario();

		try {

			String sql = "SELECT ID, LOGIN, NOME, SENHA FROM USUARIO WHERE LOGIN = ? ";

			this.con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, codigo);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Long id = rs.getLong("id");
				String login = rs.getString("login");
				String nome = rs.getString("nome");
				String senha = rs.getString("senha");

				usuario.setId(id);
				usuario.setLogin(login);
				usuario.setNome(nome);
				usuario.setSenha(senha);
			}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return usuario;
		} finally {
			ConnectionFactory.closeConnection(con);
		}

		return usuario;
	}

	public List<Usuario> getAllUsuarios() {

		List<Usuario> usuarios = new ArrayList<Usuario>();

		try {

			String sql = "SELECT ID, LOGIN, NOME, SENHA FROM USUARIO ORDER BY NOME";

			this.con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Long id = rs.getLong("id");
				String login = rs.getString("login");
				String nome = rs.getString("nome");
				String senha = rs.getString("senha");

				Usuario usuario = new Usuario(id, login, nome, senha);
				usuarios.add(usuario);
			}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return usuarios;
		} finally {
			ConnectionFactory.closeConnection(con);
		}

		return usuarios;
	}

	public void updateUsuario(Usuario usuario) {

		try {
			String sql = "UPDATE USUARIO SET LOGIN = ?, NOME = ?, SENHA = ? WHERE ID = ? ";

			this.con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getNome());
			stmt.setString(3, usuario.getSenha());
			stmt.setLong(4, usuario.getId());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con);
		}

	}
	
	public void deleteByLogin (String login) {
		
		try {
			
			String sql = "DELETE FROM USUARIO WHERE LOGIN = ? ";
			
			this.con  = ConnectionFactory.getConnection();
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, login);
			
			stmt.execute();
			stmt.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con);
		}

	}
}
