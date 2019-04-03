package com.fish2048.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fish2048.training.domain.Ph;
import com.fish2048.training.repositories.PhRepository;

/**
 * @author Gabriel Mauro
 *
 */
@Service
public class PhService {
	@Autowired
	private PhRepository phRepository;

	// CREATES
	public Ph insert(Ph ph) {
		ph.setId(null);
		return phRepository.save(ph);
	}

	// READS
	public List<Ph> findAll() {
		return phRepository.findAll();
	}

	public Ph find(Integer id) {
		Optional<Ph> ph = phRepository.findById(id);
		return ph.orElse(null);
	}

	// UPDATES
	public Ph update(Ph ph) {
		Ph newPh = find(ph.getId());
		newPh.setAfericaoPh(ph.getAfericaoPh());
		return phRepository.save(newPh);
	}

	// DELETES
	public void delete(Integer id) {
		find(id);
		try {
			phRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel excluir este registro!");
		}
	}

}
