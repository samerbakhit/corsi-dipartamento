package com.university.universitymanagement.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Studente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private String nome;
private String cognome;
private String email;
@Temporal(TemporalType.DATE)
private Date dataNascita;
@OneToOne(cascade = CascadeType.ALL)

@JoinColumn(name="tessera_id")
private Tessera tessera;
@ManyToMany(fetch = FetchType.EAGER)

@JoinTable(
		name="studenti_corsi",
		joinColumns= @JoinColumn(name="studente_id"),
		inverseJoinColumns= @JoinColumn(name="corso_id")
		)
private Set<Corso> corsi = new HashSet<>();




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
public String getCognome() {
	return cognome;
}
public void setCognome(String cognome) {
	this.cognome = cognome;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Date getDataNascita() {
	return dataNascita;
}
public void setDataNascita(Date dataNascita) {
	this.dataNascita = dataNascita;
}
public Tessera getTessera() {
	return tessera == null ? new Tessera() : tessera;
}
public void setTessera(Tessera tessera) {
	this.tessera = tessera;
}



public Studente() {
	super();
}
public Set<Corso> getCorsi() {
	return corsi;
}
public void setCorsi(Set<Corso> corsi) {
	this.corsi = corsi;
}
public Studente(Long id, String nome, String cognome, String email, Date dataNascita, Tessera tessera,
		Set<Corso> corsi) {
	super();
	this.id = id;
	this.nome = nome;
	this.cognome = cognome;
	this.email = email;
	this.dataNascita = dataNascita;
	this.tessera = tessera;
	this.corsi = corsi;
}


}
