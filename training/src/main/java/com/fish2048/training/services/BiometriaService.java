package com.fish2048.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fish2048.training.domain.Biometria;
import com.fish2048.training.repositories.BiometriaRepository;

@Service
public class BiometriaService {

	@Autowired
	private BiometriaRepository biometriaRepository;
	
	// FIND ALL
	public List<Biometria> findAll() {
		List<Biometria> obj = biometriaRepository.findAll();
		return obj;
	}
	
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
	
	// UPDATE
	public Biometria update(Biometria obj) {
		Biometria newObj = find(obj.getId());
		newObj.setComprimentoMedio(obj.getComprimentoMedio());
		newObj.setDataHoraBiometria(obj.getDataHoraBiometria());
		newObj.setObservacoes(obj.getObservacoes());
		newObj.setPesoMedio(obj.getPesoMedio());
		return biometriaRepository.save(newObj);
	}
	
	// DELETE
	public void delete(Integer id) {
		find(id);
		try {
			biometriaRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel excluir este registro!");
		}
	}
}