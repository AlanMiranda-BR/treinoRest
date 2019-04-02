package com.fish2048.training.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fish2048.training.domain.Pesquisa;
import com.fish2048.training.repositories.PesquisaRepository;

@Service
public class PesquisaService {
	@Autowired
	private PesquisaRepository pesquisaRepository;
	
	//FIND BY ID
	public Pesquisa find(Integer id) {
		Optional<Pesquisa> obj = pesquisaRepository.findById(id);
		return obj.orElse(null);
	}
	//INSERT	
	public Pesquisa insert (Pesquisa obj) {
		obj.setId(null);
		return pesquisaRepository.save(obj);
	}
}
