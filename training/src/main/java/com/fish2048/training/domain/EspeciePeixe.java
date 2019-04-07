package com.fish2048.training.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Vitória Ramos
 *
 */
@Entity
public class EspeciePeixe implements Serializable {
	private static final long serialVersionUID = 1L;

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomeCientifico;
	private String nomePopular;

	// Relacionamentos
	@OneToMany(mappedBy = "especiePeixe")
	private List<LotePeixe> lotepeixe = new ArrayList<>();
	
	// Construtores
	public EspeciePeixe() {
	}

	public EspeciePeixe(Integer id, String nomeCientifico, String nomePopular) {
		super();
		this.id = id;
		this.nomeCientifico = nomeCientifico;
		this.nomePopular = nomePopular;
	}

	// Getters e Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeCientifico() {
		return nomeCientifico;
	}

	public void setNomeCientifico(String nomeCientifico) {
		this.nomeCientifico = nomeCientifico;
	}

	public String getNomePopular() {
		return nomePopular;
	}

	public void setNomePopular(String nomePopular) {
		this.nomePopular = nomePopular;
	}

	public List<LotePeixe> getLotepeixe() {
		return lotepeixe;
	}

	public void setLotepeixe(List<LotePeixe> lotepeixe) {
		this.lotepeixe = lotepeixe;
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
		EspeciePeixe other = (EspeciePeixe) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
