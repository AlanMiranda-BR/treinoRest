package com.fish2048.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fish2048.training.domain.TaxaArracoamento;
import com.fish2048.training.repositories.TaxaArracoamentoRepository;

/**
 * @author Wellinton Camboim
 *
 */
@Service
public class TaxaArracoamentoService {
	@Autowired
	private TaxaArracoamentoRepository taxaArracoamentoRepository;

	// CREATES
	public TaxaArracoamento insert(TaxaArracoamento taxaArracoamento) {
		taxaArracoamento.setId(null);
		return taxaArracoamentoRepository.save(taxaArracoamento);
	}

	// READS
	public List<TaxaArracoamento> findAll() {
		List<TaxaArracoamento> taxaArracoamento = taxaArracoamentoRepository.findAll();
		return taxaArracoamento;
	}

	public TaxaArracoamento find(Integer id) {
		Optional<TaxaArracoamento> taxaArracoamento = taxaArracoamentoRepository.findById(id);
		return taxaArracoamento.orElse(null);
	}

	// UPDATES
	public TaxaArracoamento update(TaxaArracoamento taxaArracoamento) {
		TaxaArracoamento newTaxaArracoamento = find(taxaArracoamento.getId());
		newTaxaArracoamento.setDataHoraArracoamento(taxaArracoamento.getDataHoraArracoamento());
		newTaxaArracoamento.setPesoMedio(taxaArracoamento.getPesoMedio());
		newTaxaArracoamento.setTemperaturaH20(taxaArracoamento.getTemperaturaH20());
		newTaxaArracoamento.setPorcentagemPB(taxaArracoamento.getPorcentagemPB());
		newTaxaArracoamento.setObservacoes(taxaArracoamento.getObservacoes());
		return taxaArracoamentoRepository.save(newTaxaArracoamento);
	}

	// DELETES
	public void delete(Integer id) {
		find(id);
		try {
			taxaArracoamentoRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel excluir este registro!");
		}
	}
}
