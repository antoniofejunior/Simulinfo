package br.com.bean;

public class Usuario {
	private Long id;
	private String login;
	private String nome;
	private String senha;
	
	public Usuario (Long id, String login, String nome, String senha) {
		this.login = login;
		this.nome = nome;
		this.senha = senha;
		this.id = id;
	}
	
	public Usuario (String login, String nome, String senha) {
		this.login = login;
		this.nome = nome;
		this.senha = senha;
	}
	
	public Usuario () {
		
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
