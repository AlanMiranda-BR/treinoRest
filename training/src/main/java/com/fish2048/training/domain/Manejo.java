package com.fish2048.training.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * @author Gabriel Mauro
 *
 */
@Entity
public class Manejo implements Serializable {
	private static final long serialVersionUID = 1L;

	// Atributos
	@EmbeddedId
	private ManejoPK id = new ManejoPK();
	private String tipoManejo;
	private String observacoes;
	
	// Construtores
	public Manejo() {
	}

	public Manejo(ManejoPK id, String tipoManejo, String observacoes) {
		super();
		this.id = id;
		this.tipoManejo = tipoManejo;
		this.observacoes = observacoes;
	}

	// Getters and Setters
	public ManejoPK getId() {
		return id;
	}

	public void setId(ManejoPK id) {
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