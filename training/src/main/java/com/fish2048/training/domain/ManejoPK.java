package com.fish2048.training.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Classe auxiliar da Classe Manejo, utilizada para ser a chave primária
 * composta de Manejo. A chave é composta pelo id de Povoamento e uma data/hora.
 * Os HashCodes e equals devem ser de todos os atributos que compoem a chave composta.
 * 
 * @author Alan Felipe Miranda
 *
 */
@Embeddable
public class ManejoPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "povoamento_id")
	private Povoamento povoamento;
	
	// Junção do data e hora dos atributos manejo
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHora;
	
	public ManejoPK() {}
	
	public ManejoPK(Povoamento povoamento, Date dataHora) {
		super();
		this.povoamento = povoamento;
		this.dataHora = dataHora;
	}
	
	// Getters e Setters
	public Povoamento getPovoamento() {
		return povoamento;
	}

	public void setPovoamento(Povoamento povoamento) {
		this.povoamento = povoamento;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataHora == null) ? 0 : dataHora.hashCode());
		result = prime * result + ((povoamento == null) ? 0 : povoamento.hashCode());
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
		ManejoPK other = (ManejoPK) obj;
		if (dataHora == null) {
			if (other.dataHora != null)
				return false;
		} else if (!dataHora.equals(other.dataHora))
			return false;
		if (povoamento == null) {
			if (other.povoamento != null)
				return false;
		} else if (!povoamento.equals(other.povoamento))
			return false;
		return true;
	}

}
