package br.com.bean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Questao {
	private Long id;
	private String descricao;
	private String data;
	private Assunto assunto;
	private Concurso concurso;
	private Admin admin;
	private List<Alternativa> alternativas;
	
	public Questao(String descricao, Assunto assunto, Concurso concurso, Admin admin) {
		
		this.descricao = descricao;
		SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		this.data = format.format( new Date() );
		
		this.assunto = assunto;
		this.concurso = concurso;
		this.admin = admin;
		this.alternativas = new ArrayList<Alternativa>();
	}
	
	public Questao(Long id, String descricao, String data, Assunto assunto, Concurso concurso, Admin admin, List<Alternativa> alternativas) {
		
		this.id = id;
		this.descricao = descricao;
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");  
	    this.data = format.format( new Date() );
		
		this.concurso = concurso;
		this.admin = admin;
		this.alternativas = alternativas;
		
	}

	public Questao() {
		
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Assunto getAssunto() {
		return assunto;
	}

	public void setAssunto(Assunto assunto) {
		this.assunto = assunto;
	}

	public Concurso getConcurso() {
		return concurso;
	}

	public void setConcurso(Concurso concurso) {
		this.concurso = concurso;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public List<Alternativa> getAlternativas() {
		return alternativas;
	}
	
	public void addAlternativa(Alternativa alternativa) {
		this.alternativas.add(alternativa);
	}
	
	public void setAlternativas(List<Alternativa> alternativas) {
		this.alternativas = alternativas;
	}
}