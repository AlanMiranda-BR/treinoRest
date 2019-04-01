package com.fish2048.training.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fish2048.training.domain.Pesquisador;
import com.fish2048.training.repositories.PesquisadorRepository;

@Service
public class PesquisadorService {
	@Autowired
	private PesquisadorRepository pesquisadorRepository;
	
	//FIND BY ID
	public Pesquisador find(Integer id) {
		Optional<Pesquisador> obj = pesquisadorRepository.findById(id);
		return obj.orElse(null);
	}
	
	//INSERT
	public Pesquisador insert (Pesquisador obj) {
		obj.setId(null);
		return pesquisadorRepository.save(obj);		
	}

}
