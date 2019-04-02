package com.fish2048.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fish2048.training.domain.IndiceZootecnico;
import com.fish2048.training.repositories.IndiceZootecnicoRepository;

@Service
public class IndiceZootecnicoService {
	
	@Autowired
	private IndiceZootecnicoRepository indiceZootecnicoRepository;
	
	// FIND ALL
	public List<IndiceZootecnico> findAll() {
		List<IndiceZootecnico> obj = indiceZootecnicoRepository.findAll();
		return obj;
	}
	
	// Find by Id
	public IndiceZootecnico find(Integer id) {
		Optional<IndiceZootecnico> obj = indiceZootecnicoRepository.findById(id);
		return obj.orElse(null);
	}
	
	// INSERT
	public IndiceZootecnico insert(IndiceZootecnico obj) {
		obj.setId(null);
		return indiceZootecnicoRepository.save(obj);
	}
	
	// UPDATE
	public IndiceZootecnico update(IndiceZootecnico obj) {
		IndiceZootecnico newObj = find(obj.getId());
		newObj.setConversaoAlimentar(obj.getConversaoAlimentar());
		newObj.setCrescimentoEspecifico(obj.getCrescimentoEspecifico());
		newObj.setDataHoraIndiceZootecnico(obj.getDataHoraIndiceZootecnico());
		newObj.setGanhoBiomassa(obj.getGanhoBiomassa());
		newObj.setGanhoPesoDiario(obj.getGanhoPesoDiario());
		newObj.setGanhoPesoTotal(obj.getGanhoPesoTotal());
		newObj.setObservacoes(obj.getObservacoes());
		newObj.setTaxaDeSobrevivencia(obj.getTaxaDeSobrevivencia());
		return indiceZootecnicoRepository.save(newObj);
	}
	
	// DELETE
	public void delete(Integer id) {
		find(id);
		try {
			indiceZootecnicoRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel excluir este registro!");
		}
	}

}
