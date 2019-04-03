package com.fish2048.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fish2048.training.domain.Biometria;
import com.fish2048.training.repositories.BiometriaRepository;

/**
 * @author Pedro Lz
 *
 */
@Service
public class BiometriaService {

	@Autowired
	private BiometriaRepository biometriaRepository;

	// CREATE
	public Biometria insert(Biometria biometria) {
		biometria.setId(null);
		return biometriaRepository.save(biometria);
	}

	// READS
	public List<Biometria> findAll() {
		List<Biometria> biometria = biometriaRepository.findAll();
		return biometria;
	}

	public Biometria find(Integer id) {
		Optional<Biometria> biometria = biometriaRepository.findById(id);
		return biometria.orElse(null);
	}

	// UPDATE
	public Biometria update(Biometria biometria) {
		Biometria newBiometria = find(biometria.getId());
		newBiometria.setComprimentoMedio(biometria.getComprimentoMedio());
		newBiometria.setDataHoraBiometria(biometria.getDataHoraBiometria());
		newBiometria.setObservacoes(biometria.getObservacoes());
		newBiometria.setPesoMedio(biometria.getPesoMedio());
		return biometriaRepository.save(newBiometria);
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