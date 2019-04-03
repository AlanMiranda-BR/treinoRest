package com.fish2048.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fish2048.training.domain.Publicacao;
import com.fish2048.training.repositories.PublicacaoRepository;

/**
 * @author Wellinton Camboim
 *
 */
@Service
public class PublicacaoService {
	@Autowired
	private PublicacaoRepository publicacaoRepository;

	// CREATES
	public Publicacao insert(Publicacao publicacao) {
		publicacao.setId(null);
		return publicacaoRepository.save(publicacao);
	}

	// READS
	public List<Publicacao> findAll() {
		List<Publicacao> publicacao = publicacaoRepository.findAll();
		return publicacao;
	}

	public Publicacao find(Integer id) {
		Optional<Publicacao> publicacao = publicacaoRepository.findById(id);
		return publicacao.orElse(null);
	}

	// UPDATES
	public Publicacao update(Publicacao publicacao) {
		Publicacao newPublicacao = find(publicacao.getId());
		newPublicacao.setAgenciaPublicacao(publicacao.getAgenciaPublicacao());
		newPublicacao.setDataPublicacao(publicacao.getDataPublicacao());
		newPublicacao.setFatorImpactoPublicacao(publicacao.getFatorImpactoPublicacao());
		newPublicacao.setLocalPublicacao(publicacao.getLocalPublicacao());
		newPublicacao.setTipoPublicacao(publicacao.getTipoPublicacao());
		return publicacaoRepository.save(newPublicacao);
	}

	// DELETES
	public void delete(Integer id) {
		find(id);
		try {
			publicacaoRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel excluir este registro!");
		}
	}
}
