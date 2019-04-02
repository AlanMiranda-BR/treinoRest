package com.fish2048.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fish2048.training.domain.Cultivo;
import com.fish2048.training.repositories.CultivoRepository;

@Service
public class CultivoService {
	@Autowired
	private CultivoRepository cultivoRepository;
	
	//Create
	public Cultivo insert(Cultivo obj) {
		obj.setId(null);
		return cultivoRepository.save(obj);
	}
	
	//Read
	public Cultivo find(Integer id) {
		Optional<Cultivo> obj = cultivoRepository.findById(id); 
		return obj.orElse(null);
	}
	
	public List<Cultivo> findAll() {
		return cultivoRepository.findAll();
	}
	
	//Update
	public Cultivo update(Cultivo obj) {
		Cultivo newObj = find(obj.getId());
		newObj.setDescricao(obj.getDescricao());
		return cultivoRepository.save(newObj);
	}
	
	//Delete
	public void delete(Integer id) {
		cultivoRepository.deleteById(id);
	}
	
}
