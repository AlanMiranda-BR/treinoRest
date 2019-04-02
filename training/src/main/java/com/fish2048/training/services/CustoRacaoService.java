package com.fish2048.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.fish2048.training.domain.CustoRacao;
import com.fish2048.training.repositories.CustoRacaoRepository;

@Service
public class CustoRacaoService {
	
	@Autowired
	private CustoRacaoRepository custoRacaoRepository;

	// FIND ALL
	public List<CustoRacao> findAll() {
		List<CustoRacao> obj = custoRacaoRepository.findAll();
		return obj;		
	}

	// FIND BY ID
	public CustoRacao find(Integer id) {
		Optional<CustoRacao> obj = custoRacaoRepository.findById(id);
		return obj.orElse(null);
		}
	
	// INSERT
	public CustoRacao insert(CustoRacao obj) {
		obj.setId(null);
		return custoRacaoRepository.save(obj);
	}
	
	// UPDATE
	public CustoRacao update(CustoRacao obj) {
		CustoRacao newObj = find(obj.getId());
		newObj.setObservacoes(obj.getObservacoes());
		newObj.setDataCompra(obj.getDataCompra());
		newObj.setValorTotalCompra(obj.getValorTotalCompra());
		newObj.setQtdCompra(obj.getQtdCompra());
		return custoRacaoRepository.save(newObj);
	}

	// DELETE
	public void delete(Integer id) {
		find(id);
		try {
			custoRacaoRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel excluir este registro!");
		}
	}
	
	
}
