package com.samer.dbCrud.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="studenti")
public class Studenti {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message="Deve inserire il nome")
	
	private String nome;
	@NotBlank(message="Deve inserire il cognome")
	private String cognome;
	@NotNull(message="Deve inserire gli anni")
	private Integer anni;
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
	
	public Integer getAnni() {
		return anni;
	}
	public void setAnni(Integer anni) {
		this.anni = anni;
	}
	public Studenti() {
		super();
	}
	public Studenti(Long id, @NotBlank(message = "Deve inserire il nome") String nome,
			@NotBlank(message = "Deve inserire il cognome") String cognome,
			@NotNull(message = "Deve inserire gli anni") Integer anni) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.anni = anni;
	}
	

}
