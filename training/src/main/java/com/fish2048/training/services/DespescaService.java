package com.fish2048.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fish2048.training.domain.Despesca;
import com.fish2048.training.repositories.DespescaRepository;

/**
 * @author Alan Felipe Miranda
 *
 */
@Service
public class DespescaService {
	@Autowired
	private DespescaRepository despescaRepository;

	// CREATES
	public Despesca insert(Despesca despesca) {
		despesca.setId(null);
		return despescaRepository.save(despesca);
	}

	// READS
	public Despesca find(Integer id) {
		Optional<Despesca> despesca = despescaRepository.findById(id);
		return despesca.orElse(null);
	}

	public List<Despesca> findAll() {
		return despescaRepository.findAll();
	}

	// UPDATES
	public Despesca update(Despesca despesca) {
		Despesca newDespesca = find(despesca.getId());
		newDespesca.setDataDespesca(despesca.getDataDespesca());
		newDespesca.setQtdPeixeDespescado(despesca.getQtdPeixeDespescado());
		return despescaRepository.save(newDespesca);
	}

	// DELETES
	public void delete(Integer id) {
		despescaRepository.deleteById(id);
	}
}
