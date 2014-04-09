package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bean.Assunto;
import br.com.bean.Resultado;
import br.com.bean.Usuario;

public class ResultadoDao {

	private Connection con;

	public void addResultado(Resultado resultado) {
		try {
			String sql = "INSERT INTO RESULTADO (USUARIO, PONTUACAO, ASSUNTO) VALUES (?,?,?)";

			this.con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setLong(1, resultado.getUsuario().getId());
			stmt.setInt(2, resultado.getPontuacao());
			stmt.setLong(3, resultado.getAssunto().getId());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(con);
		}
	}

	public Resultado getResultado(Long codigo) {
		
		Resultado resultado = new Resultado();

		try {
			
			UsuarioDao usuarioDao = new UsuarioDao();
			AssuntoDao assuntoDao = new AssuntoDao();

			String sql = "SELECT ID, USUARIO, PONTUACAO, ASSUNTO FROM RESULTADO WHERE ID = ? ";

			this.con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, codigo);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Long id = rs.getLong("id");
				
				Long usuario = rs.getLong("usuario");
				Usuario u = usuarioDao.getById(usuario);
				
				Long assunto = rs.getLong("assunto");
				Assunto a = assuntoDao.getAssunto(assunto);
				
				int pontuacao = rs.getInt("pontuacao");
				
				resultado.setId(id);
				resultado.setUsuario(u);
				resultado.setPontuacao(pontuacao);
				resultado.setAssunto(a);

			}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return resultado;
		} finally {
			ConnectionFactory.closeConnection(con);
		}

		return resultado;
	}
	

	public List<Resultado> getAllResultados() {

		List<Resultado> resultados = new ArrayList<Resultado>();

		try {
			UsuarioDao usuarioDao = new UsuarioDao();
			AssuntoDao assuntoDao = new AssuntoDao();
			
			String sql = "SELECT ID, USUARIO, PONTUACAO, ASSUNTO FROM RESULTADO ORDER BY PONTUACAO DESC";

			this.con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Long id = rs.getLong("id");
				
				Long usuario = rs.getLong("usuario");
				Usuario u = usuarioDao.getById(usuario);
				
				Long assunto = rs.getLong("assunto");
				Assunto a = assuntoDao.getAssunto(assunto);
				
				int pontuacao = rs.getInt("pontuacao");

				Resultado resultado = new Resultado(id, u, pontuacao, a);
				resultados.add(resultado);
			}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return resultados;
		} finally {
			ConnectionFactory.closeConnection(con);
		}

		return resultados;
	}

	public void updateResultado(Resultado resultado) {

		try {
			String sql = "UPDATE RESULTADO SET USUARIO = ?, PONTUACAO = ?, ASSUNTO = ? WHERE ID = ? ";

			this.con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setLong(1, resultado.getUsuario().getId());
			stmt.setInt(2, resultado.getPontuacao());
			stmt.setLong(3, resultado.getAssunto().getId());
			stmt.setLong(4, resultado.getId());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con);
		}

	}

	public void deleteResultado(Resultado resultado) {

		try {

			String sql = "DELETE FROM RESULTADO WHERE ID = ? ";

			this.con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, resultado.getId());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con);
		}

	}
}
