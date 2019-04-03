package com.fish2048.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fish2048.training.domain.Pesquisador;
import com.fish2048.training.repositories.PesquisadorRepository;

/**
 * @author Wellinton Camboim
 *
 */
@Service
public class PesquisadorService {
	@Autowired
	private PesquisadorRepository pesquisadorRepository;

	// CREATES
	public Pesquisador insert(Pesquisador pesquisador) {
		pesquisador.setId(null);
		return pesquisadorRepository.save(pesquisador);
	}

	// READS
	public List<Pesquisador> findAll() {
		List<Pesquisador> pesquisador = pesquisadorRepository.findAll();
		return pesquisador;
	}

	public Pesquisador find(Integer id) {
		Optional<Pesquisador> pesquisador = pesquisadorRepository.findById(id);
		return pesquisador.orElse(null);
	}

	// UPDATES
	public Pesquisador update(Pesquisador pesquisador) {
		Pesquisador newPesquisador = find(pesquisador.getId());
		newPesquisador.setCentroTrabalho(pesquisador.getCentroTrabalho());
		newPesquisador.setEmailPesquisador(pesquisador.getEmailPesquisador());
		newPesquisador.setEspecialidade(pesquisador.getEspecialidade());
		newPesquisador.setMatriculaPesquisador(pesquisador.getMatriculaPesquisador());
		newPesquisador.setNomePesquisador(pesquisador.getNomePesquisador());
		newPesquisador.setTelefone(pesquisador.getTelefone());
		return pesquisadorRepository.save(newPesquisador);
	}

	// DELETES
	public void delete(Integer id) {
		find(id);
		try {
			pesquisadorRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel excluir este registro!");
		}
	}

}
