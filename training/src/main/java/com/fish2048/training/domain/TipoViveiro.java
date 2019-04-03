package com.fish2048.training.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * @author Gabriel Mauro
 *
 */
@Entity
public class TipoViveiro implements Serializable {
	private static final long serialVersionUID = 1L;

	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String observacoes;
	
	//Construtores
	public TipoViveiro() {
		
	}
	
	public TipoViveiro(Integer id, String observacoes) {
		super();
		this.id = id;
		this.observacoes = observacoes;
	}

	//Getters e Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
 	
}
