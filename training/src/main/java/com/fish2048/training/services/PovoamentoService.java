package com.fish2048.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fish2048.training.domain.Povoamento;
import com.fish2048.training.repositories.PovoamentoRepository;

/**
 * @author Alan Felipe Miranda 
 * Classe responsável por implementar os métodos de
 *         CRUD().
 */
@Service
public class PovoamentoService {
	@Autowired
	private PovoamentoRepository povoamentoRepository;

	// FIND ALL
	public List<Povoamento> findAll() {
		List<Povoamento> obj = povoamentoRepository.findAll();
		return obj;
	}

	// FIND BY ID
	public Povoamento find(Integer id) {
		Optional<Povoamento> obj = povoamentoRepository.findById(id);
		return obj.orElse(null);
	}

	// INSERT
	public Povoamento insert(Povoamento obj) {
		obj.setId(null);
		return povoamentoRepository.save(obj);
	}

	// UPDATE
	public Povoamento update(Povoamento obj) {
		Povoamento newObj = find(obj.getId());
		newObj.setDataPovoamento(obj.getDataPovoamento());
		newObj.setQtdPeixePovoamento(obj.getQtdPeixePovoamento());
		return povoamentoRepository.save(newObj);
	}

	// DELETE
	public void delete(Integer id) {
		find(id);
		try {
			povoamentoRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel excluir este registro!");
		}
	}
}
