package com.fish2048.training.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fish2048.training.domain.LotePeixe;
import com.fish2048.training.repositories.LotePeixeRepository;


@Service
public class LotePeixeService {
	
	@Autowired
	private LotePeixeRepository lotePeixeRepository;
	
	public LotePeixe find(Integer id) {
		Optional<LotePeixe> obj = lotePeixeRepository.findById(id);
		return obj.orElse(null);

	}
	
	public LotePeixe insert(LotePeixe obj) {
		obj.setId(null);
		return lotePeixeRepository.save(obj);
	}


}
