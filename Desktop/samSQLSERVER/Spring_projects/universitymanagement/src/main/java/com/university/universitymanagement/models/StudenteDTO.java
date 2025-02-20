package com.university.universitymanagement.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudenteDTO {
	private String nome;
    private String cognome;
    private String email;
    private Date dataNascita;
    private String codiceTessera;
    private Date dataEmissione;
    private String statoTessera;
  
   

	private List<Long> corsoIds=new ArrayList<>(); 
    
	public List<Long> getCorsoIds() {
		return corsoIds;
	}
	public void setCorsoIds(List<Long> corsoIds) {
		this.corsoIds = corsoIds;
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
	public String getCodiceTessera() {
		return codiceTessera;
	}
	public void setCodiceTessera(String codiceTessera) {
		this.codiceTessera = codiceTessera;
	}
	public Date getDataEmissione() {
		return dataEmissione;
	}
	public void setDataEmissione(Date dataEmissione) {
		this.dataEmissione = dataEmissione;
	}
	public String getStatoTessera() {
		return statoTessera;
	}
	public void setStatoTessera(String statoTessera) {
		this.statoTessera = statoTessera;
	}
    
}
