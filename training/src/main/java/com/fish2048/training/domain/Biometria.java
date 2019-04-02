package com.fish2048.training.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author pedro lz
 *
 *	Falta adicionar métodos CalcularPesoMedi()
 *	e CalcularComprimentoMedio()
 */
@Entity
public class Biometria implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// atributos da classe
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	// Fusão dos atributos dataBiometria e horaBiometria
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataHoraBiometria;
	private Float pesoMedio;
	private Float comprimentoMedio;
	private String observacoes;
	
	// Construtores e get e setters
	public Biometria() {}

	public Biometria(Integer id, Date dataHoraBiometria, Float pesoMedio, float comprimentoMedio, String observacoes) {
		this.id = id;
		this.dataHoraBiometria = dataHoraBiometria;
		this.pesoMedio = pesoMedio;
		this.comprimentoMedio = comprimentoMedio;
		this.observacoes = observacoes;
	}

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

	public Float getPesoMedio() {
		return pesoMedio;
	}

	public void setPesoMedio(Float pesoMedio) {
		this.pesoMedio = pesoMedio;
	}

	public float getComprimentoMedio() {
		return comprimentoMedio;
	}

	public void setComprimentoMedio(float comprimentoMedio) {
		this.comprimentoMedio = comprimentoMedio;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
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
		Biometria other = (Biometria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}