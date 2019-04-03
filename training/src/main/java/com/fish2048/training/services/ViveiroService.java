package com.fish2048.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fish2048.training.domain.Povoamento;
import com.fish2048.training.domain.Viveiro;
import com.fish2048.training.repositories.ViveiroRepository;

/**
 * @author Jhon
 *
 */
@Service
public class ViveiroService {
	@Autowired
	private ViveiroRepository viveiroRepository;

	// CREATES

	
	public Viveiro insert(Viveiro viveiro) {
		viveiro.setId(null);
		return viveiroRepository.save(viveiro);
	}

	// READS
	public List<Viveiro> findAll() {
		List<Viveiro> viveiro = viveiroRepository.findAll();
		return viveiro;
	}

	public Viveiro find(Integer id) {
		Optional<Viveiro> viveiro = viveiroRepository.findById(id);
		return viveiro.orElse(null);
	}

	// UPDATES
	public Viveiro update(Viveiro viveiro) {
		Viveiro newViveiro = find(viveiro.getId());
		newViveiro.setIdTipoViveiro(viveiro.getIdTipoViveiro());
		newViveiro.setSuperficieAgua(viveiro.getSuperficieAgua());
		return viveiroRepository.save(newViveiro);
	}

	// DELETES
	public void delete(Integer id) {
		find(id);
		try {
			viveiroRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não foi possivel excluir este registro");
		}
	}
}
