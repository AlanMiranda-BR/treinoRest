package com.fish2048.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fish2048.training.domain.Pesquisa;
import com.fish2048.training.repositories.PesquisaRepository;

/**
 * @author Wellinton Camboim
 *
 */
@Service
public class PesquisaService {
	@Autowired
	private PesquisaRepository pesquisaRepository;

	// CREATES
	public Pesquisa insert(Pesquisa pesquisa) {
		pesquisa.setId(null);
		return pesquisaRepository.save(pesquisa);
	}

	// READS
	public List<Pesquisa> findAll() {
		List<Pesquisa> pesquisa = pesquisaRepository.findAll();
		return pesquisa;
	}

	public Pesquisa find(Integer id) {
		Optional<Pesquisa> pesquisa = pesquisaRepository.findById(id);
		return pesquisa.orElse(null);
	}

	// UPDATES
	public Pesquisa update(Pesquisa pesquisa) {
		Pesquisa newPesquisa = find(pesquisa.getId());
		newPesquisa.setDataFim(pesquisa.getDataFim());
		newPesquisa.setDataInicio(pesquisa.getDataInicio());
		return pesquisaRepository.save(newPesquisa);
	}

	// DELETES
	public void delete(Integer id) {
		find(id);
		try {
			pesquisaRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel excluir este registro!");
		}
	}
}
