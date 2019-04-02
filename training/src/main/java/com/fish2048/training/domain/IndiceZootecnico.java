package com.fish2048.training.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * @author pedro
 *	
 *	Foi feito só os métodos CRUDS
 */
@Entity
public class IndiceZootecnico implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	//	Fusão entre dataIndiceZootecnico e horaIndiceZootecnico
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataHoraIndiceZootecnico;
	private Float ganhoPesoTotal;
	private Float ganhoPesoDiario;
	private Float ganhoBiomassa;
	private Float taxaDeSobrevivencia;
	private Float crescimentoEspecifico;
	private Float conversaoAlimentar;
	private String observacoes;
	
	public IndiceZootecnico() {}
	
	public IndiceZootecnico(Integer id, Date dataHoraIndiceZootecnico, Float ganhoPesoTotal, Float ganhoPesoDiario,
			Float ganhoBiomassa, Float taxaDeSobrevivencia, Float crescimentoEspecifico, Float conversaoAlimentar,
			String observacoes) {
		super();
		this.id = id;
		this.dataHoraIndiceZootecnico = dataHoraIndiceZootecnico;
		this.ganhoPesoTotal = ganhoPesoTotal;
		this.ganhoPesoDiario = ganhoPesoDiario;
		this.ganhoBiomassa = ganhoBiomassa;
		this.taxaDeSobrevivencia = taxaDeSobrevivencia;
		this.crescimentoEspecifico = crescimentoEspecifico;
		this.conversaoAlimentar = conversaoAlimentar;
		this.observacoes = observacoes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataHoraIndiceZootecnico() {
		return dataHoraIndiceZootecnico;
	}

	public void setDataHoraIndiceZootecnico(Date dataHoraIndiceZootecnico) {
		this.dataHoraIndiceZootecnico = dataHoraIndiceZootecnico;
	}

	public Float getGanhoPesoTotal() {
		return ganhoPesoTotal;
	}

	public void setGanhoPesoTotal(Float ganhoPesoTotal) {
		this.ganhoPesoTotal = ganhoPesoTotal;
	}

	public Float getGanhoPesoDiario() {
		return ganhoPesoDiario;
	}

	public void setGanhoPesoDiario(Float ganhoPesoDiario) {
		this.ganhoPesoDiario = ganhoPesoDiario;
	}

	public Float getGanhoBiomassa() {
		return ganhoBiomassa;
	}

	public void setGanhoBiomassa(Float ganhoBiomassa) {
		this.ganhoBiomassa = ganhoBiomassa;
	}

	public Float getTaxaDeSobrevivencia() {
		return taxaDeSobrevivencia;
	}

	public void setTaxaDeSobrevivencia(Float taxaDeSobrevivencia) {
		this.taxaDeSobrevivencia = taxaDeSobrevivencia;
	}

	public Float getCrescimentoEspecifico() {
		return crescimentoEspecifico;
	}

	public void setCrescimentoEspecifico(Float crescimentoEspecifico) {
		this.crescimentoEspecifico = crescimentoEspecifico;
	}

	public Float getConversaoAlimentar() {
		return conversaoAlimentar;
	}

	public void setConversaoAlimentar(Float conversaoAlimentar) {
		this.conversaoAlimentar = conversaoAlimentar;
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
		IndiceZootecnico other = (IndiceZootecnico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
