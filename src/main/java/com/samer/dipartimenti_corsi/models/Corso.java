package com.samer.dipartimenti_corsi.models;

import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Corso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descrizione;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="dipartimento_id")
	@JsonIgnore
	private Dipartimento dipartimento;
	private int crediti;

	public int getCrediti() {
		return crediti;
	}

	public void setCrediti(int crediti) {
		this.crediti = crediti;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Dipartimento getDipartimento() {
		return dipartimento;
	}

	public void setDipartimento(Dipartimento dipartimento) {
		this.dipartimento = dipartimento;
	}

	public Corso(Long id, String nome, String descrizione, Dipartimento dipartimento, int crediti) {
		super();
		this.id = id;
		this.nome = nome;
		this.descrizione = descrizione;
		this.dipartimento = dipartimento;
		this.crediti = crediti;
	}

	public Corso() {
		super();
	}



}
