package com.fish2048.training.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fish2048.training.domain.EspeciePeixe;
import com.fish2048.training.repositories.EspeciePeixeRepository;

@Service
public class EspeciePeixeService {
	@Autowired
	private EspeciePeixeRepository especiePeixeRepository;

	public EspeciePeixe find(Integer id) {
		Optional<EspeciePeixe> obj = especiePeixeRepository.findById(id);
		return obj.orElse(null);

	}

	public EspeciePeixe insert(EspeciePeixe obj) {
		obj.setId(null);
		return especiePeixeRepository.save(obj);
	}

}
