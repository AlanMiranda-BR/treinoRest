package com.fish2048.training.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Parametro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	// Fusão dos atributos dataParametros e horaParametros
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataHoraParametro;
	private Double qtdOxigenioDissolvido;
	private Double temperaturaH20;
	private String alcalinidade;
	private String dureza;
	private String condutividade;
	private String sanilidade;
	private String saturacao;
	private String observacoes;
	
	public Parametro() {}

	public Parametro(Integer id, Date dataHoraParametro, Double qtdOxigenioDissolvido, Double temperaturaH20,
			String alcalinidade, String dureza, String condutividade, String sanilidade, String saturacao,
			String observacoes) {
		super();
		this.id = id;
		this.dataHoraParametro = dataHoraParametro;
		this.qtdOxigenioDissolvido = qtdOxigenioDissolvido;
		this.temperaturaH20 = temperaturaH20;
		this.alcalinidade = alcalinidade;
		this.dureza = dureza;
		this.condutividade = condutividade;
		this.sanilidade = sanilidade;
		this.saturacao = saturacao;
		this.observacoes = observacoes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataHoraParametro() {
		return dataHoraParametro;
	}

	public void setDataHoraParametro(Date dataHoraParametro) {
		this.dataHoraParametro = dataHoraParametro;
	}

	public Double getQtdOxigenioDissolvido() {
		return qtdOxigenioDissolvido;
	}

	public void setQtdOxigenioDissolvido(Double qtdOxigenioDissolvido) {
		this.qtdOxigenioDissolvido = qtdOxigenioDissolvido;
	}

	public Double getTemperaturaH20() {
		return temperaturaH20;
	}

	public void setTemperaturaH20(Double temperaturaH20) {
		this.temperaturaH20 = temperaturaH20;
	}

	public String getAlcalinidade() {
		return alcalinidade;
	}

	public void setAlcalinidade(String alcalinidade) {
		this.alcalinidade = alcalinidade;
	}

	public String getDureza() {
		return dureza;
	}

	public void setDureza(String dureza) {
		this.dureza = dureza;
	}

	public String getCondutividade() {
		return condutividade;
	}

	public void setCondutividade(String condutividade) {
		this.condutividade = condutividade;
	}

	public String getSanilidade() {
		return sanilidade;
	}

	public void setSanilidade(String sanilidade) {
		this.sanilidade = sanilidade;
	}

	public String getSaturacao() {
		return saturacao;
	}

	public void setSaturacao(String saturacao) {
		this.saturacao = saturacao;
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
		Parametro other = (Parametro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
