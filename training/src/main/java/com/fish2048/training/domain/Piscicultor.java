package com.fish2048.training.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Jhon
 *
 */
@Entity
public class Piscicultor implements Serializable {
	private static final long serialVersionUID = 1L;

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String especialidade;
	private String telefone;
	private String email;
	
	// Relacionamentos
	@OneToMany(mappedBy = "piscicultor")
	@JsonIgnore
	private List<Povoamento> povoamentos = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name = "piscicultor_propriedade")
	private List<Propriedade> propriedades = new ArrayList<>();

	// Construtores
	public Piscicultor() {
	}

	public Piscicultor(Integer id, String nome, String especialidade, String telefone, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.especialidade = especialidade;
		this.telefone = telefone;
		this.email = email;
	}

	// Getters e Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Povoamento> getPovoamentos() {
		return povoamentos;
	}

	public void setPovoamentos(List<Povoamento> povoamentos) {
		this.povoamentos = povoamentos;
	}

	public List<Propriedade> getPropriedades() {
		return propriedades;
	}

	public void setPropriedades(List<Propriedade> propriedades) {
		this.propriedades = propriedades;
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
		Piscicultor other = (Piscicultor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
