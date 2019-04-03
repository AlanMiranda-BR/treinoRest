package com.fish2048.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fish2048.training.domain.Autorias;
import com.fish2048.training.repositories.AutoriasRepository;

/**
 * @author Wellinton Camboim
 * @Todo Concluido implementação
 *
 */
@Service
public class AutoriasService {
	@Autowired
	private AutoriasRepository autoriasRepository;

	// CREATE
	public Autorias insert(Autorias autorias) {
		autorias.setId(null);
		return autoriasRepository.save(autorias);
	}

	// READS
	public Autorias find(Integer id) {
		Optional<Autorias> autorias = autoriasRepository.findById(id);
		return autorias.orElse(null);
	}

	public List<Autorias> findAll() {
		return autoriasRepository.findAll();
	}

	// UPDATE
	public Autorias update(Autorias autorias) {
		Autorias newAutorias = find(autorias.getId());
		newAutorias.setMatriculaPesquisador(autorias.getMatriculaPesquisador());
		return autoriasRepository.save(newAutorias);
	}

	// DELETE
	public void delete(Integer id) {
		find(id);
		try {
			autoriasRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel excluir este registro!");
		}
	}

}
