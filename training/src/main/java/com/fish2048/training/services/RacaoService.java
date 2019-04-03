package com.fish2048.training.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.fish2048.training.domain.Racao;
import com.fish2048.training.repositories.RacaoRepository;

/**
 * @author Rafael Silva Neukirchen
 *
 */
@Service
public class RacaoService {

	@Autowired
	private RacaoRepository racaoRepository;

	// CREATES
	public Racao insert(Racao obj) {
		obj.setId(null);
		return racaoRepository.save(obj);
	}

	// READS
	public List<Racao> findAll() {
		List<Racao> obj = racaoRepository.findAll();
		return obj;
	}

	public Racao find(Integer id) {
		Optional<Racao> obj = racaoRepository.findById(id);
		return obj.orElse(null);
	}

	// UPDATES
	public Racao update(Racao obj) {
		Racao newObj = find(obj.getId());
		newObj.setTipoRacao(obj.getTipoRacao());
		newObj.setQtdProteina(obj.getQtdProteina());
		newObj.setObservacoes(obj.getObservacoes());
		return racaoRepository.save(newObj);
	}

	// DELETES
	public void delete(Integer id) {
		find(id);
		try {
			racaoRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel excluir este registro!");
		}
	}

}
