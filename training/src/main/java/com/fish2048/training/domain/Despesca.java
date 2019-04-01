package com.fish2048.training.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Despesca implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer qtdPeixeDespescado;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataDespesca;
	
	//construtor vazio 
	public Despesca() {
	}

	//contrutor
	public Despesca(Integer id, Integer qtdPeixeDespescado, Date dataDespesca) {
		super();
		this.id = id;
		this.qtdPeixeDespescado = qtdPeixeDespescado;
		this.dataDespesca = dataDespesca;
	}

	//getters e setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQtdPeixeDespescado() {
		return qtdPeixeDespescado;
	}

	public void setQtdPeixeDespescado(Integer qtdPeixeDespescado) {
		this.qtdPeixeDespescado = qtdPeixeDespescado;
	}

	public Date getDataDespesca() {
		return dataDespesca;
	}

	public void setDataDespesca(Date dataDespesca) {
		this.dataDespesca = dataDespesca;
	}

	//hashCode e equals
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
		Despesca other = (Despesca) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
