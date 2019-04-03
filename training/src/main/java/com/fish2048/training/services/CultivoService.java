package com.fish2048.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fish2048.training.domain.Cultivo;
import com.fish2048.training.repositories.CultivoRepository;

/**
 * @author Alan Felipe Miranda
 *
 */
@Service
public class CultivoService {
	@Autowired
	private CultivoRepository cultivoRepository;

	// CREATES
	public Cultivo insert(Cultivo cultivo) {
		cultivo.setId(null);
		return cultivoRepository.save(cultivo);
	}

	// READS
	public Cultivo find(Integer id) {
		Optional<Cultivo> cultivo = cultivoRepository.findById(id);
		return cultivo.orElse(null);
	}

	public List<Cultivo> findAll() {
		return cultivoRepository.findAll();
	}

	// UPDATES
	public Cultivo update(Cultivo cultivo) {
		Cultivo newCultivo = find(cultivo.getId());
		newCultivo.setDescricao(cultivo.getDescricao());
		return cultivoRepository.save(newCultivo);
	}

	// DELETES
	public void delete(Integer id) {
		cultivoRepository.deleteById(id);
	}

}
