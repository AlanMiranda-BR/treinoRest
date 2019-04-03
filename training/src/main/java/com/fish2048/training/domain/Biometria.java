package com.fish2048.training.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Pedro Lz
 *
 * @Todo Falta adicionar métodos CalcularPesoMedi() e CalcularComprimentoMedio()
 */
@Entity
public class Biometria implements Serializable {
	private static final long serialVersionUID = 1L;

	// Atributos da classe
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	// Fusão dos atributos dataBiometria e horaBiometria
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataHoraBiometria;
	private Double pesoMedio;
	private Double comprimentoMedio;
	private String observacoes;

	// Construtores
	public Biometria() {
	}

	public Biometria(Integer id, Date dataHoraBiometria, Double pesoMedio, Double comprimentoMedio,
			String observacoes) {
		this.id = id;
		this.dataHoraBiometria = dataHoraBiometria;
		this.pesoMedio = pesoMedio;
		this.comprimentoMedio = comprimentoMedio;
		this.observacoes = observacoes;
	}

	// Getters e Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataHoraBiometria() {
		return dataHoraBiometria;
	}

	public void setDataHoraBiometria(Date dataHoraBiometria) {
		this.dataHoraBiometria = dataHoraBiometria;
	}

	public Double getPesoMedio() {
		return pesoMedio;
	}

	public void setPesoMedio(Double pesoMedio) {
		this.pesoMedio = pesoMedio;
	}

	public Double getComprimentoMedio() {
		return comprimentoMedio;
	}

	public void setComprimentoMedio(Double comprimentoMedio) {
		this.comprimentoMedio = comprimentoMedio;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
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
		Biometria other = (Biometria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}