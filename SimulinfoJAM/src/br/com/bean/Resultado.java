package br.com.bean;

public class Resultado {
	private Long id;
	private Usuario usuario;
	private int pontuacao;
	private Assunto assunto;
	
	public Resultado(Usuario usuario, int pontuacao, Assunto assunto) {
		this.usuario = usuario;
		this.pontuacao = pontuacao;
		this.assunto = assunto;
	}
	
	public Resultado(Long id, Usuario usuario, int pontuacao, Assunto assunto) {
		this.id = id;
		this.usuario = usuario;
		this.pontuacao = pontuacao;
		this.assunto = assunto;
	}

	public Resultado() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public int getPontuacao() {
		return pontuacao;
	}
	
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	public Assunto getAssunto() {
		return assunto;
	}
	
	public void setAssunto(Assunto assunto) {
		this.assunto = assunto;
	}
	
}
