package br.com.bean;

public class Concurso {
	private Long id;
	private String descricao;
	private int ano;
	
	public Concurso (Long id, String descricao, int ano) {
		this.id = id;
		this.descricao = descricao;
		this.ano = ano;
	}
	
	
	public Concurso (String descricao, int ano) {
		this.descricao = descricao;
		this.ano = ano;
	}
	
	public Concurso () {
		
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
	
	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
}
