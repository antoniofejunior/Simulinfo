package br.com.bean;

public class Alternativa {
	private Long id;
	private String descricao;
	private boolean correta;
	private Long questao;
	
	public Alternativa(Long id, String descricao, boolean status, Long questao) {
		this.id = id;
		this.descricao = descricao;
		this.correta = status;
		this.questao = questao;
	}

	public Alternativa(String descricao, boolean status, Long questao) {
		this.descricao = descricao;
		this.correta = status;
		this.questao = questao;
	}

	public Alternativa() {
		
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

	public boolean isCorreta() {
		return correta;
	}

	public void setCorreta(boolean status) {
		this.correta = status;
	}

	public Long getQuestao() {
		return questao;
	}

	public void setQuestao(Long questao) {
		this.questao = questao;
	}
	
}