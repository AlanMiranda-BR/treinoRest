package com.fish2048.training.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.fish2048.training.domain.Alimentacao;
import com.fish2048.training.repositories.AlimentacaoRepository;

/**
 * @author Rafael Silva Neukirchen
 * @Tudo OK, foi somente colocado na ordem e feito os comentários para ficar
 *       padrão com os demais
 */
@Service
public class AlimentacaoService {

	@Autowired
	private AlimentacaoRepository alimentacaoRepository;

	// CREATES
	public Alimentacao insert(Alimentacao alimentacao) {
		alimentacao.setId(null);
		return alimentacaoRepository.save(alimentacao);
	}

	// READS
	public List<Alimentacao> findAll() {
		List<Alimentacao> alimentacao = alimentacaoRepository.findAll();
		return alimentacao;
	}

	public Alimentacao find(Integer id) {
		Optional<Alimentacao> alimentacao = alimentacaoRepository.findById(id);
		return alimentacao.orElse(null);
	}

	// UPDATES
	public Alimentacao update(Alimentacao alimentacao) {
		Alimentacao newAlimentacao = find(alimentacao.getId());
		newAlimentacao.setDataHoraAlimentacao(alimentacao.getDataHoraAlimentacao());
		newAlimentacao.setObservacoes(alimentacao.getObservacoes());
		newAlimentacao.setPesoMedio(alimentacao.getPesoMedio());
		newAlimentacao.setQtdOxigenioDissolvido(alimentacao.getPesoMedio());
		newAlimentacao.setQtdRacao(alimentacao.getQtdRacao());
		newAlimentacao.setTaxaAlimentacao(alimentacao.getTaxaAlimentacao());
		newAlimentacao.setTemperaturaH2O(alimentacao.getTemperaturaH2O());
		return alimentacaoRepository.save(newAlimentacao);
	}

	// DELETES
	public void delete(Integer id) {
		find(id);
		try {
			alimentacaoRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel excluir este registro!");
		}
	}
}
