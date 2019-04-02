package com.fish2048.training.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pesquisador implements Serializable {
	
	private static final long serialVersionUID = 1L;

	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomePesquisador;
	private Integer matriculaPesquisador;
	private String especialidade;
	private Integer telefone;
	private String emailPesquisador; 
	private String centroTrabalho;
	
	//Métodos
	//Construtor Vazio
	public Pesquisador() {}
	
	//Construtor
	public Pesquisador(Integer id, String nomePesquisador, Integer matriculaPesquisador, String especialidade,
			Integer telefone, String emailPesquisador, String centroTrabalho) {
		super();
		this.id = id;
		this.nomePesquisador = nomePesquisador;
		this.matriculaPesquisador = matriculaPesquisador;
		this.especialidade = especialidade;
		this.telefone = telefone;
		this.emailPesquisador = emailPesquisador;
		this.centroTrabalho = centroTrabalho;
	}

	//Métodos
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNomePesquisador() {
		return nomePesquisador;
	}


	public void setNomePesquisador(String nomePesquisador) {
		this.nomePesquisador = nomePesquisador;
	}


	public Integer getMatriculaPesquisador() {
		return matriculaPesquisador;
	}


	public void setMatriculaPesquisador(Integer matriculaPesquisador) {
		this.matriculaPesquisador = matriculaPesquisador;
	}


	public String getEspecialidade() {
		return especialidade;
	}


	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}


	public Integer getTelefone() {
		return telefone;
	}


	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}


	public String getEmailPesquisador() {
		return emailPesquisador;
	}


	public void setEmailPesquisador(String emailPesquisador) {
		this.emailPesquisador = emailPesquisador;
	}


	public String getCentroTrabalho() {
		return centroTrabalho;
	}


	public void setCentroTrabalho(String centroTrabalho) {
		this.centroTrabalho = centroTrabalho;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pesquisador other = (Pesquisador) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

	
}
