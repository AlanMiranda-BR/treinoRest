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
	private Integer idPropriedade;
	private Integer idPovoamento;
	private Float superficieAgua;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataCriacaoViveiro;

	// Relacionamentos
	@ManyToOne
	private TipoViveiro tipoViveiro;

	// Construtores
	public Viveiro() {
	}

	public Viveiro(Integer id, Integer idPropriedade, Integer idPovoamento, Float superficieAgua,
			Date dataCriacaoViveiro) {
		super();
		this.id = id;
		this.idPropriedade = idPropriedade;
		this.idPovoamento = idPovoamento;
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

	public Integer getIdPropriedade() {
		return idPropriedade;
	}

	public void setIdPropriedade(Integer idPropriedade) {
		this.idPropriedade = idPropriedade;
	}

	public Integer getIdPovoamento() {
		return idPovoamento;
	}

	public void setIdPovoamento(Integer idPovoamento) {
		this.idPovoamento = idPovoamento;
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
