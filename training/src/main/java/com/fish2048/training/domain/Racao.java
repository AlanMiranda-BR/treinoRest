package com.fish2048.training.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Rafael Silva Neukirchen
 *
 */
@Entity
public class Racao implements Serializable {
	private static final long serialVersionUID = 1L;

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private String tipoRacao;
	private Integer qtdProteina;
	private String observacoes;
	
	// Relacionamentos
	@OneToMany(mappedBy = "racao")
	@JsonIgnore
	private List<CustoRacao> custoRacoes;

	// Construtores
	public Racao() {
	}

	public Racao(Integer id, String tipoRacao, Integer qtdProteina, String observacoes) {
		super();
		this.id = id;
		this.tipoRacao = tipoRacao;
		this.qtdProteina = qtdProteina;
		this.observacoes = observacoes;
	}

	// Getters e Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipoRacao() {
		return tipoRacao;
	}

	public void setTipoRacao(String tipoRacao) {
		this.tipoRacao = tipoRacao;
	}

	public Integer getQtdProteina() {
		return qtdProteina;
	}

	public void setQtdProteina(Integer qtdProteina) {
		this.qtdProteina = qtdProteina;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public List<CustoRacao> getCustoRacoes() {
		return custoRacoes;
	}

	public void setCustoRacoes(List<CustoRacao> custoRacoes) {
		this.custoRacoes = custoRacoes;
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
		Racao other = (Racao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
