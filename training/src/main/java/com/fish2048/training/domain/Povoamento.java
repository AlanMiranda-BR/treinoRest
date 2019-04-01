package com.fish2048.training.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Alan Felipe Miranda.
 * 
 *         Classe responsavel por relacionar todas as demais. Qualquer
 *         informação relevante a classe deve ser estar aqui. Informações
 *         específicas dos métodos devem estar em JavaDocs logo acima do método
 *         a que se refere. A organização das classes deve ser padronizada
 *         separando por seção, identificadas com "//nome da seção"
 */
@Entity
public class Povoamento implements Serializable {
	private static final long serialVersionUID = 1L;

	// atributos da classe
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer qtdPeixePovoamento;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataPovoamento;

	// construtor vazio
	public Povoamento() {
	}

	// construtor
	public Povoamento(Integer id, Integer qtdPeixePovoamento, Date dataPovoamento) {
		super();
		this.id = id;
		this.qtdPeixePovoamento = qtdPeixePovoamento;
		this.dataPovoamento = dataPovoamento;
	}

	// getters e setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQtdPeixePovoamento() {
		return qtdPeixePovoamento;
	}

	public void setQtdPeixePovoamento(Integer qtdPeixePovoamento) {
		this.qtdPeixePovoamento = qtdPeixePovoamento;
	}

	public Date getDataPovoamento() {
		return dataPovoamento;
	}

	public void setDataPovoamento(Date dataPovoamento) {
		this.dataPovoamento = dataPovoamento;
	}

	// hashCode e equals
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
		Povoamento other = (Povoamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
