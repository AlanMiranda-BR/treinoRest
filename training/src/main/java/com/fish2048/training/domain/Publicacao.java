package com.fish2048.training.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Publicacao implements Serializable {

	private static final long serialVersionUID = 1L;

	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer codPuclicacao;
	private String tipoPublicacao;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataPublicacao;
	
	private String localPublicacao;
	private String agenciaPublicacao;
	private String fatorImpactoPublicacao;

	//Métodos
	//Construtor Vazio
	public Publicacao() {}
	
	//Construtor
	public Publicacao(Integer id, Integer codPuclicacao, String tipoPublicacao, Date dataPublicacao,
			String localPublicacao, String agenciaPublicacao, String fatorImpactoPublicacao) {
		super();
		this.id = id;
		this.codPuclicacao = codPuclicacao;
		this.tipoPublicacao = tipoPublicacao;
		this.dataPublicacao = dataPublicacao;
		this.localPublicacao = localPublicacao;
		this.agenciaPublicacao = agenciaPublicacao;
		this.fatorImpactoPublicacao = fatorImpactoPublicacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCodPuclicacao() {
		return codPuclicacao;
	}

	public void setCodPuclicacao(Integer codPuclicacao) {
		this.codPuclicacao = codPuclicacao;
	}

	public String getTipoPublicacao() {
		return tipoPublicacao;
	}

	public void setTipoPublicacao(String tipoPublicacao) {
		this.tipoPublicacao = tipoPublicacao;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public String getLocalPublicacao() {
		return localPublicacao;
	}

	public void setLocalPublicacao(String localPublicacao) {
		this.localPublicacao = localPublicacao;
	}

	public String getAgenciaPublicacao() {
		return agenciaPublicacao;
	}

	public void setAgenciaPublicacao(String agenciaPublicacao) {
		this.agenciaPublicacao = agenciaPublicacao;
	}

	public String getFatorImpactoPublicacao() {
		return fatorImpactoPublicacao;
	}

	public void setFatorImpactoPublicacao(String fatorImpactoPublicacao) {
		this.fatorImpactoPublicacao = fatorImpactoPublicacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agenciaPublicacao == null) ? 0 : agenciaPublicacao.hashCode());
		result = prime * result + ((codPuclicacao == null) ? 0 : codPuclicacao.hashCode());
		result = prime * result + ((dataPublicacao == null) ? 0 : dataPublicacao.hashCode());
		result = prime * result + ((fatorImpactoPublicacao == null) ? 0 : fatorImpactoPublicacao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((localPublicacao == null) ? 0 : localPublicacao.hashCode());
		result = prime * result + ((tipoPublicacao == null) ? 0 : tipoPublicacao.hashCode());
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
		Publicacao other = (Publicacao) obj;
		if (agenciaPublicacao == null) {
			if (other.agenciaPublicacao != null)
				return false;
		} else if (!agenciaPublicacao.equals(other.agenciaPublicacao))
			return false;
		if (codPuclicacao == null) {
			if (other.codPuclicacao != null)
				return false;
		} else if (!codPuclicacao.equals(other.codPuclicacao))
			return false;
		if (dataPublicacao == null) {
			if (other.dataPublicacao != null)
				return false;
		} else if (!dataPublicacao.equals(other.dataPublicacao))
			return false;
		if (fatorImpactoPublicacao == null) {
			if (other.fatorImpactoPublicacao != null)
				return false;
		} else if (!fatorImpactoPublicacao.equals(other.fatorImpactoPublicacao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (localPublicacao == null) {
			if (other.localPublicacao != null)
				return false;
		} else if (!localPublicacao.equals(other.localPublicacao))
			return false;
		if (tipoPublicacao == null) {
			if (other.tipoPublicacao != null)
				return false;
		} else if (!tipoPublicacao.equals(other.tipoPublicacao))
			return false;
		return true;
	}
	
	

	
}
