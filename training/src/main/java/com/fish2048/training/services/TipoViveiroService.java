package com.fish2048.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fish2048.training.domain.TipoViveiro;
import com.fish2048.training.repositories.TipoViveiroRepository;

/**
 * @author Gabriel Mauro
 *
 */
@Service
public class TipoViveiroService {
	@Autowired
	private TipoViveiroRepository tipoViveiroRepository;

	// CREATES
	public TipoViveiro insert(TipoViveiro tipoViveiro) {
		tipoViveiro.setId(null);
		return tipoViveiroRepository.save(tipoViveiro);
	}

	// READS
	public List<TipoViveiro> findAll() {
		List<TipoViveiro> tipoViveiro = tipoViveiroRepository.findAll();
		return tipoViveiro;
	}
	
	public TipoViveiro find(Integer id) {
		Optional<TipoViveiro> tipoViveiro = tipoViveiroRepository.findById(id);
		return tipoViveiro.orElse(null);
	}
	
	// UPDATES
	public TipoViveiro update(TipoViveiro tipoViveiro) {
		TipoViveiro newTipoViveiro = find(tipoViveiro.getId());
		newTipoViveiro.setDescricao(tipoViveiro.getDescricao());
		return tipoViveiroRepository.save(newTipoViveiro);
	}
	
	// DELETES
	public void delete(Integer id) {
		find(id);
		try {
			tipoViveiroRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel excluir esse arquivo!");
		}
	}
	
}
