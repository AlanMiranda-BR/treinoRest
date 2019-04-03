package com.fish2048.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.fish2048.training.domain.CustoRacao;
import com.fish2048.training.repositories.CustoRacaoRepository;

/**
 * @author Rafael Silva Neukirchen
 *
 */
@Service
public class CustoRacaoService {

	@Autowired
	private CustoRacaoRepository custoRacaoRepository;

	// CREATES
	public CustoRacao insert(CustoRacao custoRacao) {
		custoRacao.setId(null);
		return custoRacaoRepository.save(custoRacao);
	}

	// READS
	public List<CustoRacao> findAll() {
		List<CustoRacao> custoRacao = custoRacaoRepository.findAll();
		return custoRacao;
	}

	public CustoRacao find(Integer id) {
		Optional<CustoRacao> custoRacao = custoRacaoRepository.findById(id);
		return custoRacao.orElse(null);
	}

	// UPDATES
	public CustoRacao update(CustoRacao custoRacao) {
		CustoRacao newCustoRacao = find(custoRacao.getId());
		newCustoRacao.setObservacoes(custoRacao.getObservacoes());
		newCustoRacao.setDataCompra(custoRacao.getDataCompra());
		newCustoRacao.setValorTotalCompra(custoRacao.getValorTotalCompra());
		newCustoRacao.setQtdCompra(custoRacao.getQtdCompra());
		return custoRacaoRepository.save(newCustoRacao);
	}

	// DELETES
	public void delete(Integer id) {
		find(id);
		try {
			custoRacaoRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel excluir este registro!");
		}
	}
}
