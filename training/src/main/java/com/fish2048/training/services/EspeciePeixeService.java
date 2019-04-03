package com.fish2048.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fish2048.training.domain.EspeciePeixe;
import com.fish2048.training.repositories.EspeciePeixeRepository;

/**
 * @author Vitória Ramos
 * 
 */
@Service
public class EspeciePeixeService {
	@Autowired
	private EspeciePeixeRepository especiePeixeRepository;

	// CREATES
	public EspeciePeixe insert(EspeciePeixe especiePeixe) {
		especiePeixe.setId(null);
		return especiePeixeRepository.save(especiePeixe);
	}

	// READS
	public List<EspeciePeixe> findAll() {
		List<EspeciePeixe> especiePeixe = especiePeixeRepository.findAll();
		return especiePeixe;
	}

	public EspeciePeixe find(Integer id) {
		Optional<EspeciePeixe> especiePeixe = especiePeixeRepository.findById(id);
		return especiePeixe.orElse(null);
	}

	// UPDATES
	public EspeciePeixe update(EspeciePeixe especiePeixe) {
		EspeciePeixe newEspeciePeixe = find(especiePeixe.getId());
		newEspeciePeixe.setNomeCientifico(especiePeixe.getNomeCientifico());
		newEspeciePeixe.setNomePopular(especiePeixe.getNomePopular());
		return especiePeixeRepository.save(newEspeciePeixe);
	}

	// DELETES
	public void delete(Integer id) {
		find(id);
		try {
			especiePeixeRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel excluir este registro!");
		}
	}

}
