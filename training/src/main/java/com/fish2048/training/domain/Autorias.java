package com.fish2048.training.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Autorias implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer matriculaPesquisador;
	private Integer codPesquisa;
	private Integer codFuncao;
	
	//Métodos
	//Construtor Vazio
	public Autorias() {}

	//Construtor
	public Autorias(Integer id, Integer matriculaPesquisador, Integer codPesquisa, Integer codFuncao) {
		super();
		this.id = id;
		this.matriculaPesquisador = matriculaPesquisador;
		this.codPesquisa = codPesquisa;
		this.codFuncao = codFuncao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMatriculaPesquisador() {
		return matriculaPesquisador;
	}

	public void setMatriculaPesquisador(Integer matriculaPesquisador) {
		this.matriculaPesquisador = matriculaPesquisador;
	}

	public Integer getCodPesquisa() {
		return codPesquisa;
	}

	public void setCodPesquisa(Integer codPesquisa) {
		this.codPesquisa = codPesquisa;
	}

	public Integer getCodFuncao() {
		return codFuncao;
	}

	public void setCodFuncao(Integer codFuncao) {
		this.codFuncao = codFuncao;
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
		Autorias other = (Autorias) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
