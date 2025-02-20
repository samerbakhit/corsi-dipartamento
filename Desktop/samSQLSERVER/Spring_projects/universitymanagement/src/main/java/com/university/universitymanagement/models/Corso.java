package com.university.universitymanagement.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Corso {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descrizione;
	 @ManyToMany(fetch = FetchType.LAZY)
	 @JsonIgnore
	private Set<Studente> studenti = new HashSet<>();
	@ManyToOne
	@JoinColumn(name="dipartamento_id")
	private Dipartamento dipartamento;
	
	private int crediti;
	

	
	
	
	public Set<Studente> getStudenti() {
		return studenti;
	}
	public void setStudenti(Set<Studente> studenti) {
		this.studenti = studenti;
	}
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

	public Dipartamento getDipartamento() {
		return dipartamento;
	}
	public void setDipartamento(Dipartamento dipartamento) {
		this.dipartamento = dipartamento;
	}

	public Corso() {
		super();
	}
	public Corso(Long id, String nome, String descrizione, Set<Studente> studenti, Dipartamento dipartamento,
			int crediti) {
		super();
		this.id = id;
		this.nome = nome;
		this.descrizione = descrizione;
		this.studenti = studenti;
		this.dipartamento = dipartamento;
		this.crediti = crediti;
	}
	

}
