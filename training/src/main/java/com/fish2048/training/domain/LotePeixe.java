package com.fish2048.training.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class LotePeixe implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataLote;
	private Integer codEspeciePeixe;
	private Integer qtdTotal;
	private Float biomassa;
	private Integer pesoMedio;

	public LotePeixe() {
		
	}

	public LotePeixe(Integer id, Date dataLote, Integer codEspeciePeixe, Integer qtdTotal, float biomassa,
			Integer pesoMedio) {
		super();
		this.id = id;
		this.dataLote = dataLote;
		this.codEspeciePeixe = codEspeciePeixe;
		this.qtdTotal = qtdTotal;
		this.biomassa = biomassa;
		this.pesoMedio = pesoMedio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataLote() {
		return dataLote;
	}

	public void setDataLote(Date dataLote) {
		this.dataLote = dataLote;
	}

	public Integer getCodEspeciePeixe() {
		return codEspeciePeixe;
	}

	public void setCodEspeciePeixe(Integer codEspeciePeixe) {
		this.codEspeciePeixe = codEspeciePeixe;
	}

	public Integer getQtdTotal() {
		return qtdTotal;
	}

	public void setQtdTotal(Integer qtdTotal) {
		this.qtdTotal = qtdTotal;
	}

	public Float getBiomassa() {
		return biomassa;
	}

	public void setBiomassa(Float biomassa) {
		this.biomassa = biomassa;
	}

	public Integer getPesoMedio() {
		return pesoMedio;
	}

	public void setPesoMedio(Integer pesoMedio) {
		this.pesoMedio = pesoMedio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(biomassa);
		result = prime * result + ((codEspeciePeixe == null) ? 0 : codEspeciePeixe.hashCode());
		result = prime * result + ((dataLote == null) ? 0 : dataLote.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pesoMedio == null) ? 0 : pesoMedio.hashCode());
		result = prime * result + ((qtdTotal == null) ? 0 : qtdTotal.hashCode());
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
		LotePeixe other = (LotePeixe) obj;
		if (Float.floatToIntBits(biomassa) != Float.floatToIntBits(other.biomassa))
			return false;
		if (codEspeciePeixe == null) {
			if (other.codEspeciePeixe != null)
				return false;
		} else if (!codEspeciePeixe.equals(other.codEspeciePeixe))
			return false;
		if (dataLote == null) {
			if (other.dataLote != null)
				return false;
		} else if (!dataLote.equals(other.dataLote))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pesoMedio == null) {
			if (other.pesoMedio != null)
				return false;
		} else if (!pesoMedio.equals(other.pesoMedio))
			return false;
		if (qtdTotal == null) {
			if (other.qtdTotal != null)
				return false;
		} else if (!qtdTotal.equals(other.qtdTotal))
			return false;
		return true;
	}
	
	
}
