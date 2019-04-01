package com.fish2048.training.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fish2048.training.domain.Despesca;
import com.fish2048.training.repositories.DespescaRepository;

@Service
public class DespescaService {
	@Autowired
	private DespescaRepository despescaRepository;
	
	//FIND BY ID
	public Despesca find(Integer id) {
		Optional<Despesca> obj = despescaRepository.findById(id);
		return obj.orElse(null);
	}
	
	//INSERT
	public Despesca insert(Despesca obj) {
		obj.setId(null);
		return despescaRepository.save(obj);
	}
}
