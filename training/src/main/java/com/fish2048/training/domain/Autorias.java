package com.fish2048.training.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Wellinton Camboim
 * @todo codPesquisa e codFuncao são coleções(relacionamentos), por isso não vão
 *       no construtor, de qualquer forma eu removi para não confundir na hora
 *       de criar.
 */
@Entity
public class Autorias implements Serializable {
	private static final long serialVersionUID = 1L;

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer matriculaPesquisador;

	// Relacionamentos
	@ManyToOne
	private Pesquisa pesquisa;

	@ManyToOne
	private Pesquisador pesquisador;

	// Construtores
	public Autorias() {
	}

	public Autorias(Integer id, Integer matriculaPesquisador) {
		super();
		this.id = id;
		this.matriculaPesquisador = matriculaPesquisador;
	}

	// Getters e Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMatriculaPesquisador() {
		return matriculaPesquisador;
	}

	public void setMatriculaPesquisador(Integer matriculaPesquisador) {
		this.matriculaPesquisador = matriculaPesquisador;
	}

	public Pesquisa getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(Pesquisa pesquisa) {
		this.pesquisa = pesquisa;
	}

	public Pesquisador getPesquisador() {
		return pesquisador;
	}

	public void setPesquisador(Pesquisador pesquisador) {
		this.pesquisador = pesquisador;
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
		Autorias other = (Autorias) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
