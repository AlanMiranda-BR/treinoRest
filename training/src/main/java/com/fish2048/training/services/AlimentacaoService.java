package com.fish2048.training.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.fish2048.training.domain.Alimentacao;
import com.fish2048.training.repositories.AlimentacaoRepository;

/**
 * Criado por Rafael Silva Neukirchen
 */
@Service
public class AlimentacaoService {
	
	@Autowired
	private AlimentacaoRepository alimentacaoRepository;

	// FIND ALL
	public List<Alimentacao> findAll() {
		List<Alimentacao> obj = alimentacaoRepository.findAll();
		return obj;
	}
	
	// INSERT
	public Alimentacao insert(Alimentacao obj) {
		obj.setId(null);
		return alimentacaoRepository.save(obj);
	}
	
	// FIND BY ID
	public Alimentacao find(Integer id) {
		Optional<Alimentacao> obj = alimentacaoRepository.findById(id);
		return obj.orElse(null);
		}
	
	// UPDATE
	public Alimentacao update(Alimentacao obj) {
		Alimentacao newObj = find(obj.getId());
		newObj.setDataHoraAlimentacao(obj.getDataHoraAlimentacao());
		newObj.setObservacoes(obj.getObservacoes());
		newObj.setPesoMedio(obj.getPesoMedio());
		newObj.setQtdOxigenioDissolvido(obj.getPesoMedio());
		newObj.setQtdRacao(obj.getQtdRacao());
		newObj.setTaxaAlimentacao(obj.getTaxaAlimentacao());
		newObj.setTemperaturaH2O(obj.getTemperaturaH2O());
		return alimentacaoRepository.save(newObj);
	}
	
	// DELETE
	public void delete(Integer id) {
		find(id);
		try {
			alimentacaoRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel excluir este registro!");
		}
	}
}
