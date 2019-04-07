package com.fish2048.training.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Vitória Ramos
 *
 */
@Entity
public class LotePeixe implements Serializable {
	private static final long serialVersionUID = 1L;

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataLote;
	private Integer qtdTotal;
	private Double biomassa;
	private Integer pesoMedio;
	
	// Relacionamentos
	@ManyToMany(mappedBy = "lotesPeixes")
	@JsonIgnore
	private List<Povoamento> povoamentos = new ArrayList<>();
	
	@ManyToOne
	@JsonIgnore
	private EspeciePeixe especiePeixe;
	
	// Construtores
	public LotePeixe() {
	}

	public LotePeixe(Integer id, Date dataLote, Integer qtdTotal, Double biomassa, Integer pesoMedio) {
		super();
		this.id = id;
		this.dataLote = dataLote;
		this.qtdTotal = qtdTotal;
		this.biomassa = biomassa;
		this.pesoMedio = pesoMedio;
	}

	// Getters e Setters
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

	public Integer getQtdTotal() {
		return qtdTotal;
	}

	public void setQtdTotal(Integer qtdTotal) {
		this.qtdTotal = qtdTotal;
	}

	public Double getBiomassa() {
		return biomassa;
	}

	public void setBiomassa(Double biomassa) {
		this.biomassa = biomassa;
	}

	public Integer getPesoMedio() {
		return pesoMedio;
	}

	public void setPesoMedio(Integer pesoMedio) {
		this.pesoMedio = pesoMedio;
	}

	public List<Povoamento> getPovoamentos() {
		return povoamentos;
	}

	public void setPovoamentos(List<Povoamento> povoamentos) {
		this.povoamentos = povoamentos;
	}

	public EspeciePeixe getEspeciePeixe() {
		return especiePeixe;
	}

	public void setEspeciePeixe(EspeciePeixe especiePeixe) {
		this.especiePeixe = especiePeixe;
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
		LotePeixe other = (LotePeixe) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
