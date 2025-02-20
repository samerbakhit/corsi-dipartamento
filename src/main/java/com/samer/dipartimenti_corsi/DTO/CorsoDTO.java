package com.samer.dipartimenti_corsi.DTO;

import com.samer.dipartimenti_corsi.models.Corso;

public class CorsoDTO {
	private String nome;
	private String descrizione;
	private int crediti;
	private Long dipartimentoId;
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
	public int getCrediti() {
		return crediti;
	}
	public void setCrediti(int crediti) {
		this.crediti = crediti;
	}
	public Long getDipartimentoId() {
		return dipartimentoId;
	}
	public void setDipartimentoId(Long dipartimentoId) {
		this.dipartimentoId = dipartimentoId;
	}
	public CorsoDTO(String nome, String descrizione, int crediti, Long dipartimentoId) {
		super();
		this.nome = nome;
		this.descrizione = descrizione;
		this.crediti = crediti;
		this.dipartimentoId = dipartimentoId;
	}
	public CorsoDTO() {
		super();
	}

	

}
