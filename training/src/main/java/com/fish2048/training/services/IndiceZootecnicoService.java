package com.fish2048.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fish2048.training.domain.IndiceZootecnico;
import com.fish2048.training.repositories.IndiceZootecnicoRepository;

/**
 * @author Pedro Lz
 *
 */
@Service
public class IndiceZootecnicoService {

	@Autowired
	private IndiceZootecnicoRepository indiceZootecnicoRepository;

	// CREATES
	public IndiceZootecnico insert(IndiceZootecnico indiceZootecnico) {
		indiceZootecnico.setId(null);
		return indiceZootecnicoRepository.save(indiceZootecnico);
	}

	// READS
	public List<IndiceZootecnico> findAll() {
		List<IndiceZootecnico> indiceZootecnico = indiceZootecnicoRepository.findAll();
		return indiceZootecnico;
	}

	public IndiceZootecnico find(Integer id) {
		Optional<IndiceZootecnico> indiceZootecnico = indiceZootecnicoRepository.findById(id);
		return indiceZootecnico.orElse(null);
	}

	// UPDATES
	public IndiceZootecnico update(IndiceZootecnico indiceZootecnico) {
		IndiceZootecnico newIndiceZootecnico = find(indiceZootecnico.getId());
		newIndiceZootecnico.setConversaoAlimentar(indiceZootecnico.getConversaoAlimentar());
		newIndiceZootecnico.setCrescimentoEspecifico(indiceZootecnico.getCrescimentoEspecifico());
		newIndiceZootecnico.setDataHoraIndiceZootecnico(indiceZootecnico.getDataHoraIndiceZootecnico());
		newIndiceZootecnico.setGanhoBiomassa(indiceZootecnico.getGanhoBiomassa());
		newIndiceZootecnico.setGanhoPesoDiario(indiceZootecnico.getGanhoPesoDiario());
		newIndiceZootecnico.setGanhoPesoTotal(indiceZootecnico.getGanhoPesoTotal());
		newIndiceZootecnico.setObservacoes(indiceZootecnico.getObservacoes());
		newIndiceZootecnico.setTaxaDeSobrevivencia(indiceZootecnico.getTaxaDeSobrevivencia());
		return indiceZootecnicoRepository.save(newIndiceZootecnico);
	}

	// DELETES
	public void delete(Integer id) {
		find(id);
		try {
			indiceZootecnicoRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel excluir este registro!");
		}
	}
}
