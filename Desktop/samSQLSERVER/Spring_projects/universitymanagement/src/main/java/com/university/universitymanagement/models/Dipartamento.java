package com.university.universitymanagement.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Dipartamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String sede;
	@OneToMany(mappedBy="dipartamento",cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Corso>corsi;
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
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	public List<Corso> getCorsi() {
		return corsi;
	}
	public void setCorsi(List<Corso> corsi) {
		this.corsi = corsi;
	}
	public Dipartamento(Long id, String nome, String sede, List<Corso> corsi) {
		super();
		this.id = id;
		this.nome = nome;
		this.sede = sede;
		this.corsi = corsi;
	}
	public Dipartamento() {
		super();
	}
	

}
