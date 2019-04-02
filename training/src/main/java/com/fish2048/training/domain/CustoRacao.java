package com.fish2048.training.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author Rafael Silva Neukirchen
 *
 */

@Entity
public class CustoRacao implements Serializable {
	private static final long serialVersionUID = 1L;
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataCompra;
	private Integer qtdCompra;
	private Float valorTotalCompra;
	private String observacoes;
	
	//Construtor
	public CustoRacao() {
	}

	//get e setters
	
	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Integer getQtdCompra() {
		return qtdCompra;
	}

	public void setQtdCompra(Integer qtdCompra) {
		this.qtdCompra = qtdCompra;
	}

	public Float getValorTotalCompra() {
		return valorTotalCompra;
	}

	public void setValorTotalCompra(Float valorTotalCompra) {
		this.valorTotalCompra = valorTotalCompra;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		CustoRacao other = (CustoRacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
