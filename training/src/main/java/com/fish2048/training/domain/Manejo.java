package com.fish2048.training.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Gabriel Mauro
 *
 */
@Entity
public class Manejo implements Serializable {
	private static final long serialVersionUID = 1L;

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String tipoManejo;
	private String observacoes;
	// Junção do data e hora dos atributos manejo
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataHoraManejo;

	// Construtores
	public Manejo() {
	}

	public Manejo(Integer id, String tipoManejo, String observacoes, Date dataHoraManejo) {
		super();
		this.id = id;
		this.tipoManejo = tipoManejo;
		this.observacoes = observacoes;
		this.dataHoraManejo = dataHoraManejo;
	}

	// Getters and Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipoManejo() {
		return tipoManejo;
	}

	public void setTipoManejo(String tipoManejo) {
		this.tipoManejo = tipoManejo;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Date getDataHoraManejo() {
		return dataHoraManejo;
	}

	public void setDataHoraManejo(Date dataHoraManejo) {
		this.dataHoraManejo = dataHoraManejo;
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
		Manejo other = (Manejo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}