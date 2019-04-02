package com.fish2048.training.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fish2048.training.domain.Manejo;
import com.fish2048.training.repositories.ManejoRepository;

@Service
public class ManejoService {
	@Autowired
	private ManejoRepository manejoRepository;
	
	//FIND BY ID
	public Manejo find(Integer id) {
		Optional<Manejo> obj = manejoRepository.findById(id);
		return obj.orElse(null);
	}
	
	//INSERT
	public Manejo insert(Manejo obj) {
		obj.setId(null);
		return manejoRepository.save(obj);  
	}

}
