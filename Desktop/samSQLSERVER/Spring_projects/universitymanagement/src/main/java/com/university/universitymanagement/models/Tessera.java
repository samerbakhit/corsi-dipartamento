package com.university.universitymanagement.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Tessera {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String codice;
	@Temporal(TemporalType.DATE)
	private Date dataEmissione;
	private String stato;
	@OneToOne(mappedBy="tessera")
	@JsonIgnore
	private Studente studente;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public Date getDataEmissione() {
		return dataEmissione;
	}
	public void setDataEmissione(Date dataEmissione) {
		this.dataEmissione = dataEmissione;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	public Studente getStudente() {
		return studente;
	}
	public void setStudente(Studente studente) {
		this.studente = studente;
	}
	public Tessera(Long id, String codice, Date dataEmissione, String stato, Studente studente) {
		super();
		this.id = id;
		this.codice = codice;
		this.dataEmissione = dataEmissione;
		this.stato = stato;
		this.studente = studente;
	}
	public Tessera() {
		super();
	}
	

}
