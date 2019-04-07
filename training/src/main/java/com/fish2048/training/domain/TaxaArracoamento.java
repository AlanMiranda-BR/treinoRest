package com.fish2048.training.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Wellinton Camboim
 *
 */
@Entity
public class TaxaArracoamento implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataHoraArracoamento;
	private Float pesoMedio;
	private Float temperaturaH20;
	private Integer porcentagemPB;
	private String observacoes;
	
	// Relacionamentos
	@ManyToOne
	private Povoamento povoamento;

	// Construtores
	public TaxaArracoamento() {
	}

	public TaxaArracoamento(Integer id, Date dataHoraArracoamento, Float pesoMedio, Float temperaturaH20,
			Integer porcentagemPB, String observacoes) {
		super();
		this.id = id;
		this.dataHoraArracoamento = dataHoraArracoamento;
		this.pesoMedio = pesoMedio;
		this.temperaturaH20 = temperaturaH20;
		this.porcentagemPB = porcentagemPB;
		this.observacoes = observacoes;
	}

	// Getters e Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataHoraArracoamento() {
		return dataHoraArracoamento;
	}

	public void setDataHoraArracoamento(Date dataHoraArracoamento) {
		this.dataHoraArracoamento = dataHoraArracoamento;
	}

	public Float getPesoMedio() {
		return pesoMedio;
	}

	public void setPesoMedio(Float pesoMedio) {
		this.pesoMedio = pesoMedio;
	}

	public Float getTemperaturaH20() {
		return temperaturaH20;
	}

	public void setTemperaturaH20(Float temperaturaH20) {
		this.temperaturaH20 = temperaturaH20;
	}

	public Integer getPorcentagemPB() {
		return porcentagemPB;
	}

	public void setPorcentagemPB(Integer porcentagemPB) {
		this.porcentagemPB = porcentagemPB;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Povoamento getPovoamento() {
		return povoamento;
	}

	public void setPovoamento(Povoamento povoamento) {
		this.povoamento = povoamento;
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
		TaxaArracoamento other = (TaxaArracoamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
