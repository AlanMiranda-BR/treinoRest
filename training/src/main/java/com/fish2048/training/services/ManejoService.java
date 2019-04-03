package com.fish2048.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fish2048.training.domain.Manejo;
import com.fish2048.training.repositories.ManejoRepository;

/**
 * @author Gabriel Mauro
 *
 */
@Service
public class ManejoService {
	@Autowired
	private ManejoRepository manejoRepository;

	// READS
	public List<Manejo> findAll() {
		List<Manejo> manejo = manejoRepository.findAll();
		return manejo;
	}

	public Manejo find(Integer id) {
		Optional<Manejo> manejo = manejoRepository.findById(id);
		return manejo.orElse(null);
	}

	// CREATES
	public Manejo insert(Manejo manejo) {
		manejo.setId(null);
		return manejoRepository.save(manejo);
	}

	// UPDATES
	public Manejo update(Manejo manejo) {
		Manejo newManejo = find(manejo.getId());
		newManejo.setDataHoraManejo(manejo.getDataHoraManejo());
		newManejo.setTipoManejo(manejo.getTipoManejo());
		newManejo.setObservacoes(manejo.getObservacoes());
		return manejoRepository.save(newManejo);
	}

	// DELETES
	public void delete(Integer id) {
		find(id);
		try {
			manejoRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel excluir este registro!");
		}
	}

}
