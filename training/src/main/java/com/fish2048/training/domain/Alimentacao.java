package com.fish2048.training.domain;

/**
 * @author Rafael Silva Neukirchen
 * @Todo faltou o construtor principal, no mais tudo certo.
 */

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Alimentacao implements Serializable {
	private static final long serialVersionUID = 1L;

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	// Data e Hora JUNTOS!
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataHoraAlimentacao;
	private Double pesoMedio;
	private Double qtdOxigenioDissolvido;
	private Double temperaturaH2O;
	private Double qtdRacao;
	private Integer taxaAlimentacao;
	private String observacoes;

	// Construtores
	public Alimentacao() {
	}

	public Alimentacao(Integer id, Date dataHoraAlimentacao, Double pesoMedio, Double qtdOxigenioDissolvido,
			Double temperaturaH2O, Double qtdRacao, Integer taxaAlimentacao, String observacoes) {
		super();
		this.id = id;
		this.dataHoraAlimentacao = dataHoraAlimentacao;
		this.pesoMedio = pesoMedio;
		this.qtdOxigenioDissolvido = qtdOxigenioDissolvido;
		this.temperaturaH2O = temperaturaH2O;
		this.qtdRacao = qtdRacao;
		this.taxaAlimentacao = taxaAlimentacao;
		this.observacoes = observacoes;
	}

	// Getters e Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataHoraAlimentacao() {
		return dataHoraAlimentacao;
	}

	public void setDataHoraAlimentacao(Date dataHoraAlimentacao) {
		this.dataHoraAlimentacao = dataHoraAlimentacao;
	}

	public Double getPesoMedio() {
		return pesoMedio;
	}

	public void setPesoMedio(Double pesoMedio) {
		this.pesoMedio = pesoMedio;
	}

	public Double getQtdOxigenioDissolvido() {
		return qtdOxigenioDissolvido;
	}

	public void setQtdOxigenioDissolvido(Double qtdOxigenioDissolvido) {
		this.qtdOxigenioDissolvido = qtdOxigenioDissolvido;
	}

	public Double getTemperaturaH2O() {
		return temperaturaH2O;
	}

	public void setTemperaturaH2O(Double temperaturaH2O) {
		this.temperaturaH2O = temperaturaH2O;
	}

	public Double getQtdRacao() {
		return qtdRacao;
	}

	public void setQtdRacao(Double qtdRacao) {
		this.qtdRacao = qtdRacao;
	}

	public Integer getTaxaAlimentacao() {
		return taxaAlimentacao;
	}

	public void setTaxaAlimentacao(Integer taxaAlimentacao) {
		this.taxaAlimentacao = taxaAlimentacao;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	// HashCode e Equals
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
		Alimentacao other = (Alimentacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
