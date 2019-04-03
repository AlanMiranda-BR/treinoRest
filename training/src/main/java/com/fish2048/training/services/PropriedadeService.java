package com.fish2048.training.services;

import java.util.List;
import java.util.Optional; //para o optional 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fish2048.training.domain.Propriedade;
import com.fish2048.training.repositories.PropriedadeRepository;

/**
 * @author Jhon
 *
 */
@Service
public class PropriedadeService {
	// autowired para não haver necessidade de instanciar a classe primeiro
	// (PRopriedadeRepository é a classe) segundo é o Objeto(propriedadeRepository)
	@Autowired
	private PropriedadeRepository propriedadeRepository;

	// CREATES
	public Propriedade insert(Propriedade obj) {
		obj.setId(null);// garantir que o obj esta com o ID null para não sobrescrever
		return propriedadeRepository.save(obj);
	}

	// READS
	public List<Propriedade> findAll() {
		return propriedadeRepository.findAll();
	}

	// criando metodos de pesquisa, instanciando um objeto e retornando o mesmo.
	public Propriedade find(Integer id) {
		Optional<Propriedade> obj = propriedadeRepository.findById(id); // é preciso criar um objeto Optional, pois o
																		// mesmo pode ser nulo
		return obj.orElse(null);
	}

	// UPDATES
	public Propriedade update(Propriedade obj) {
		Propriedade newObj = find(obj.getId());
		newObj.setBairroPropriedade(obj.getBairroPropriedade());
		newObj.setCepPropriedade(obj.getCepPropriedade());
		newObj.setCidadePropriedade(obj.getCidadePropriedade());
		newObj.setEnderecoPropriedade(obj.getEnderecoPropriedade());
		newObj.setNomePropriedade(obj.getNomePropriedade());
		newObj.setNumeroPropriedade(obj.getNumeroPropriedade());
		newObj.setQtsViveirosProjeto(obj.getQtsViveirosProjeto());
		newObj.setQtsViveirosTotal(obj.getQtsViveirosTotal());
		newObj.setTelefonePropriedade(obj.getTelefonePropriedade());
		return propriedadeRepository.save(newObj);
	}

	// DELETES
	public void delete(Integer id) {
		find(id);
		try {
			propriedadeRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel excluir este registro!");
		}
	}
}
