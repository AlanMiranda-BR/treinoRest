package com.fish2048.training.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Wellinton Camboim
 *
 */
@Entity
public class Publicacao implements Serializable {
	private static final long serialVersionUID = 1L;

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String tipoPublicacao;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataPublicacao;
	private String localPublicacao;
	private String agenciaPublicacao;
	private String fatorImpactoPublicacao;

	// Construtores
	public Publicacao() {
	}

	public Publicacao(Integer id, String tipoPublicacao, Date dataPublicacao, String localPublicacao,
			String agenciaPublicacao, String fatorImpactoPublicacao) {
		super();
		this.id = id;
		this.tipoPublicacao = tipoPublicacao;
		this.dataPublicacao = dataPublicacao;
		this.localPublicacao = localPublicacao;
		this.agenciaPublicacao = agenciaPublicacao;
		this.fatorImpactoPublicacao = fatorImpactoPublicacao;
	}

	// Getters e Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	// HashCode e equals
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
		Publicacao other = (Publicacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
