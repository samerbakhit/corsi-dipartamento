package com.university.universitymanagement.models;

public class CorsoDTO {
	private String nome;
	private String descrizione;
	private Long dipartimentoId;
	private int crediti;
	
	public int getCrediti() {
		return crediti;
	}
	public void setCrediti(int crediti) {
		this.crediti = crediti;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Long getDipartimentoId() {
		return dipartimentoId;
	}
	public void setDipartimentoId(Long dipartimentoId) {
		this.dipartimentoId = dipartimentoId;
	}
	public CorsoDTO(String nome, String descrizione, Long dipartimentoId, int crediti) {
		super();
		this.nome = nome;
		this.descrizione = descrizione;
		this.dipartimentoId = dipartimentoId;
		this.crediti = crediti;
	}
	public CorsoDTO() {
		super();
	}
	
	

}
