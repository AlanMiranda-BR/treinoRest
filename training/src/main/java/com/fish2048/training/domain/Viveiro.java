package com.fish2048.training.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Jhon
 *
 */
@Entity
public class Viveiro implements Serializable {
	private static final long serialVersionUID = 1L;
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Float superficieAgua;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataCriacaoViveiro;

	// Relacionamentos
	@ManyToOne
	private TipoViveiro tipoViveiro;

	@OneToMany(mappedBy = "viveiro", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Povoamento> povoamentos = new ArrayList<>();
	
	@ManyToOne
	private Propriedade propriedade;

	// Construtores
	public Viveiro() {
	}

	public Viveiro(Integer id, Float superficieAgua, Date dataCriacaoViveiro) {
		super();
		this.id = id;
		this.superficieAgua = superficieAgua;
		this.dataCriacaoViveiro = dataCriacaoViveiro;
	}

	// Getters e Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getSuperficieAgua() {
		return superficieAgua;
	}

	public void setSuperficieAgua(Float superficieAgua) {
		this.superficieAgua = superficieAgua;
	}

	public Date getDataCriacaoViveiro() {
		return dataCriacaoViveiro;
	}

	public void setDataCriacaoViveiro(Date dataCriacaoViveiro) {
		this.dataCriacaoViveiro = dataCriacaoViveiro;
	}

	public TipoViveiro getTipoViveiro() {
		return tipoViveiro;
	}

	public void setTipoViveiro(TipoViveiro tipoViveiro) {
		this.tipoViveiro = tipoViveiro;
	}

	public List<Povoamento> getPovoamentos() {
		return povoamentos;
	}

	public void setPovoamentos(List<Povoamento> povoamentos) {
		this.povoamentos = povoamentos;
	}

	public Propriedade getPropriedade() {
		return propriedade;
	}

	public void setPropriedade(Propriedade propriedade) {
		this.propriedade = propriedade;
	}

	// Hash and Equals
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
		Viveiro other = (Viveiro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
