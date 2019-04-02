package com.fish2048.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fish2048.training.domain.Parametro;
import com.fish2048.training.repositories.ParametroRepository;

@Service
public class ParametroService {

	@Autowired
	private ParametroRepository parametroRepository;
	
	// FIND ALL
	public List<Parametro> findAll() {
		List<Parametro> obj = parametroRepository.findAll();
		return obj;
	}
	
	// Find by Id
	public Parametro find(Integer id) {
		Optional<Parametro> obj = parametroRepository.findById(id);
		return obj.orElse(null);
	}
	
	// INSERT
	public Parametro insert(Parametro obj) {
		obj.setId(null);
		return parametroRepository.save(obj);
	}
	
	// UPDATE
	public Parametro update(Parametro obj) {
		Parametro newObj = find(obj.getId());
		newObj.setAlcalinidade(obj.getAlcalinidade());
		newObj.setCondutividade(obj.getCondutividade());
		newObj.setDataHoraParametro(obj.getDataHoraParametro());
		newObj.setDureza(obj.getDureza());
		newObj.setObservacoes(obj.getObservacoes());
		newObj.setQtdOxigenioDissolvido(obj.getQtdOxigenioDissolvido());
		newObj.setSanilidade(obj.getSanilidade());
		newObj.setSaturacao(obj.getSaturacao());
		newObj.setTemperaturaH20(obj.getTemperaturaH20());
		return parametroRepository.save(newObj);
	}
	
	// DELETE
	public void delete(Integer id) {
		find(id);
		try {
			parametroRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel excluir este registro!");
		}
	}
}
