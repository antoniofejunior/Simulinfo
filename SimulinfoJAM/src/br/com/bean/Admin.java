package br.com.bean;

public class Admin {
	private Long id;
	private String login;
	private String nome;
	private String senha;
	private boolean status;
	
	public Admin(String login, String nome, String senha) {
		this.login = login;
		this.nome = nome;
		this.senha = senha;
		this.status = true;
	}
	
	public Admin(Long id, String login, String nome, String senha) {
		this.id = id;
		this.login = login;
		this.nome = nome;
		this.senha = senha;
		this.status = true;
	}
	
	public Admin () {
		
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

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
