package com.fish2048.training.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fish2048.training.domain.Biometria;
import com.fish2048.training.repositories.BiometriaRepository;

@Service
public class BiometriaService {

	@Autowired
	private BiometriaRepository biometriaRepository;
	
	// Find by Id
	public Biometria find(Integer id) {
		Optional<Biometria> obj = biometriaRepository.findById(id);
		return obj.orElse(null);
	}
	
	// INSERT
	public Biometria insert(Biometria obj) {
		obj.setId(null);
		return biometriaRepository.save(obj);
	}
}