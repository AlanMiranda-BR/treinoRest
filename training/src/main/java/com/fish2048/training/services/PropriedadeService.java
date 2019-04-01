package com.fish2048.training.services;

import java.util.Optional; //para o optional 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fish2048.training.domain.Propriedade;
import com.fish2048.training.repositories.PropriedadeRepository;

@Service
public class PropriedadeService {
//autowired para não haver necessidade de instanciar a classe
	@Autowired
// primeiro (PRopriedadeRepository é a classe) segundo é o Objeto(propriedadeRepository)
	private PropriedadeRepository propriedadeRepository;

//criando metodos de pesquisa, instanciando um objeto e retornando o mesmo.
	public Propriedade find(Integer id) {
		Optional<Propriedade> obj = propriedadeRepository.findById(id); //é preciso criar um objeto Optional, pois o mesmo pode ser nulo
		return obj.orElse(null);
	}
//criando o insert
	public Propriedade insert(Propriedade obj) {
		obj.setId(null);//garantir que o obj esta com o ID null	para não sobrescrever
		return propriedadeRepository.save(obj);
	}
//Criar o restante
}

