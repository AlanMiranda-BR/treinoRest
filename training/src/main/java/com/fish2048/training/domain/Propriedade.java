package com.fish2048.training.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Jhon
 *
 */
@Entity // PARA REPRESENTAR QUE ESTA CLASSE É UMA ENTIDADE
public class Propriedade implements Serializable {
	private static final long serialVersionUID = 1L;

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer qtsViveirosProjeto;
	private Integer qtsViveirosTotal;
	private String emailPropriedade;
	private Integer telefonePropriedade;
	private Integer cepPropriedade;
	private String bairroPropriedade;
	private String cidadePropriedade;
	private Integer numeroPropriedade;
	private String enderecoPropriedade;
	private String nomePropriedade;
	private String nomeProprietario;
	private String observacoes;

	// Construtores
	public Propriedade() {
	}

	public Propriedade(Integer id, Integer qtsViveirosProjeto, Integer qtsViveirosTotal, String emailPropriedade,
			Integer telefonePropriedade, Integer cepPropriedade, String bairroPropriedade, String cidadePropriedade,
			Integer numeroPropriedade, String enderecoPropriedade, String nomePropriedade, String nomeProprietario,
			String observacoes) {
		super();
		this.id = id;
		this.qtsViveirosProjeto = qtsViveirosProjeto;
		this.qtsViveirosTotal = qtsViveirosTotal;
		this.emailPropriedade = emailPropriedade;
		this.telefonePropriedade = telefonePropriedade;
		this.cepPropriedade = cepPropriedade;
		this.bairroPropriedade = bairroPropriedade;
		this.cidadePropriedade = cidadePropriedade;
		this.numeroPropriedade = numeroPropriedade;
		this.enderecoPropriedade = enderecoPropriedade;
		this.nomePropriedade = nomePropriedade;
		this.nomeProprietario = nomeProprietario;
		this.observacoes = observacoes;
	}

	// Getters e Setters , sem o serial version
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQtsViveirosProjeto() {
		return qtsViveirosProjeto;
	}

	public void setQtsViveirosProjeto(Integer qtsViveirosProjeto) {
		this.qtsViveirosProjeto = qtsViveirosProjeto;
	}

	public Integer getQtsViveirosTotal() {
		return qtsViveirosTotal;
	}

	public void setQtsViveirosTotal(Integer qtsViveirosTotal) {
		this.qtsViveirosTotal = qtsViveirosTotal;
	}

	public String getEmailPropriedade() {
		return emailPropriedade;
	}

	public void setEmailPropriedade(String emailPropriedade) {
		this.emailPropriedade = emailPropriedade;
	}

	public Integer getTelefonePropriedade() {
		return telefonePropriedade;
	}

	public void setTelefonePropriedade(Integer telefonePropriedade) {
		this.telefonePropriedade = telefonePropriedade;
	}

	public Integer getCepPropriedade() {
		return cepPropriedade;
	}

	public void setCepPropriedade(Integer cepPropriedade) {
		this.cepPropriedade = cepPropriedade;
	}

	public String getBairroPropriedade() {
		return bairroPropriedade;
	}

	public void setBairroPropriedade(String bairroPropriedade) {
		this.bairroPropriedade = bairroPropriedade;
	}

	public String getCidadePropriedade() {
		return cidadePropriedade;
	}

	public void setCidadePropriedade(String cidadePropriedade) {
		this.cidadePropriedade = cidadePropriedade;
	}

	public Integer getNumeroPropriedade() {
		return numeroPropriedade;
	}

	public void setNumeroPropriedade(Integer numeroPropriedade) {
		this.numeroPropriedade = numeroPropriedade;
	}

	public String getEnderecoPropriedade() {
		return enderecoPropriedade;
	}

	public void setEnderecoPropriedade(String enderecoPropriedade) {
		this.enderecoPropriedade = enderecoPropriedade;
	}

	public String getNomePropriedade() {
		return nomePropriedade;
	}

	public void setNomePropriedade(String nomePropriedade) {
		this.nomePropriedade = nomePropriedade;
	}

	public String getNomeProprietario() {
		return nomeProprietario;
	}

	public void setNomeProprietario(String nomeProprietario) {
		this.nomeProprietario = nomeProprietario;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	// HashCode e equals só o ID
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
		Propriedade other = (Propriedade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
