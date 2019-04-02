package com.fish2048.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fish2048.training.domain.Despesca;
import com.fish2048.training.repositories.DespescaRepository;

@Service
public class DespescaService {
	@Autowired
	private DespescaRepository despescaRepository;

	// Create
	public Despesca insert(Despesca obj) {
		obj.setId(null);
		return despescaRepository.save(obj);
	}
	
	// Read
	public Despesca find(Integer id) {
		Optional<Despesca> obj = despescaRepository.findById(id);
		return obj.orElse(null);
	}

	public List<Despesca> findAll() {
		return despescaRepository.findAll();
	}

	// Update
	public Despesca update(Despesca obj) {
		Despesca newObj = find(obj.getId());
		newObj.setDataDespesca(obj.getDataDespesca());
		newObj.setQtdPeixeDespescado(obj.getQtdPeixeDespescado());
		return despescaRepository.save(newObj);
	}

	// Delete
	public void delete(Integer id) {
		despescaRepository.deleteById(id);
	}
}
