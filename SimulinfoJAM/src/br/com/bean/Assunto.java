package br.com.bean;

public class Assunto {
	private Long id;
	private String descricao;
	
	public Assunto(String assunto) {
		this.descricao = assunto;
	}

	public Assunto(Long id, String assunto) {
		this.id = id;
		this.descricao = assunto;
	}
	
	public Assunto(){

	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
