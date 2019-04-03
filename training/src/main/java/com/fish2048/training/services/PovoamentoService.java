package com.fish2048.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fish2048.training.domain.Povoamento;
import com.fish2048.training.repositories.PovoamentoRepository;

/**
 * @author Alan Felipe Miranda Classe responsável por implementar os métodos de
 *         CRUD().
 */
@Service
public class PovoamentoService {
	@Autowired
	private PovoamentoRepository povoamentoRepository;

	// CREATES
	public Povoamento insert(Povoamento povoamento) {
		povoamento.setId(null);
		return povoamentoRepository.save(povoamento);
	}

	// READS
	public List<Povoamento> findAll() {
		List<Povoamento> povoamento = povoamentoRepository.findAll();
		return povoamento;
	}

	public Povoamento find(Integer id) {
		Optional<Povoamento> povoamento = povoamentoRepository.findById(id);
		return povoamento.orElse(null);
	}

	// UPDATES
	public Povoamento update(Povoamento povoamento) {
		Povoamento newPovoamento = find(povoamento.getId());
		newPovoamento.setDataPovoamento(povoamento.getDataPovoamento());
		newPovoamento.setQtdPeixePovoamento(povoamento.getQtdPeixePovoamento());
		return povoamentoRepository.save(newPovoamento);
	}

	// DELETES
	public void delete(Integer id) {
		find(id);
		try {
			povoamentoRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel excluir este registro!");
		}
	}
}
