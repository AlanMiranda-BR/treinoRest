package com.fish2048.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fish2048.training.domain.Parametro;
import com.fish2048.training.repositories.ParametroRepository;

/**
 * @author Pedro Lz
 *
 */
@Service
public class ParametroService {

	@Autowired
	private ParametroRepository parametroRepository;

	// CREATES
	public Parametro insert(Parametro parametro) {
		parametro.setId(null);
		return parametroRepository.save(parametro);
	}

	// READS
	public List<Parametro> findAll() {
		List<Parametro> parametro = parametroRepository.findAll();
		return parametro;
	}

	public Parametro find(Integer id) {
		Optional<Parametro> parametro = parametroRepository.findById(id);
		return parametro.orElse(null);
	}

	// UPDATES
	public Parametro update(Parametro parametro) {
		Parametro newParametro = find(parametro.getId());
		newParametro.setAlcalinidade(parametro.getAlcalinidade());
		newParametro.setCondutividade(parametro.getCondutividade());
		newParametro.setDataHoraParametro(parametro.getDataHoraParametro());
		newParametro.setDureza(parametro.getDureza());
		newParametro.setObservacoes(parametro.getObservacoes());
		newParametro.setQtdOxigenioDissolvido(parametro.getQtdOxigenioDissolvido());
		newParametro.setSanilidade(parametro.getSanilidade());
		newParametro.setSaturacao(parametro.getSaturacao());
		newParametro.setTemperaturaH20(parametro.getTemperaturaH20());
		return parametroRepository.save(newParametro);
	}

	// DELETES
	public void delete(Integer id) {
		find(id);
		try {
			parametroRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel excluir este registro!");
		}
	}
}
