package com.fish2048.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fish2048.training.domain.Piscicultor;
import com.fish2048.training.repositories.PiscicultorRepository;

/**
 * @author Jhon
 *
 */
@Service
public class PiscicultorService {
	@Autowired
	private PiscicultorRepository piscicultorRepository;

	// CREATES
	public Piscicultor insert(Piscicultor piscicultor) {
		piscicultor.setId(null);
		return piscicultorRepository.save(piscicultor);
	}

	// READS
	public List<Piscicultor> findAll() {
		List<Piscicultor> piscicultor = piscicultorRepository.findAll();
		return piscicultor;
	}

	public Piscicultor find(Integer id) {
		Optional<Piscicultor> piscicultor = piscicultorRepository.findById(id);
		return piscicultor.orElse(null);
	}

	// UPDATES
	public Piscicultor update(Piscicultor piscicultor) {
		Piscicultor newPiscicultor = find(piscicultor.getId());
		newPiscicultor.setEmail(piscicultor.getEmail());
		newPiscicultor.setEspecialidade(piscicultor.getEspecialidade());
		newPiscicultor.setNome(piscicultor.getNome());
		newPiscicultor.setTelefone(piscicultor.getTelefone());
		return piscicultorRepository.save(newPiscicultor);
	}

	// DELETES
	public void delete(Integer id) {
		find(id);
		try {
			piscicultorRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel excluir este registro!");
		}
	}
}