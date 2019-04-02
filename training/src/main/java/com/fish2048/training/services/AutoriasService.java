package com.fish2048.training.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fish2048.training.domain.Autorias;
import com.fish2048.training.repositories.AutoriasRepository;

@Service
public class AutoriasService {
	@Autowired
	private AutoriasRepository autoriasRepository;
	
	//FIND BY ID
	public Autorias find(Integer id) {
		Optional<Autorias> obj = autoriasRepository.findById(id);
		return obj.orElse(null);
	}
	//INSERT
	public Autorias insert (Autorias obj) {
		obj.setId(null);
		return autoriasRepository.save(obj);
	}
	
}
