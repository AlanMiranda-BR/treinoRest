package com.fish2048.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fish2048.training.domain.Manejo;
import com.fish2048.training.repositories.ManejoRepository;

@Service
public class ManejoService {
	@Autowired
	private ManejoRepository manejoRepository;
	
	// FIND ALL
		public List<Manejo> findAll() {
			List<Manejo> obj = manejoRepository.findAll();
			return obj;
		}
	
	//FIND BY ID
	public Manejo find(Integer id) {
		Optional<Manejo> obj = manejoRepository.findById(id);
		return obj.orElse(null);
	}
	
	//INSERT
	public Manejo insert(Manejo obj) {
		obj.setId(null);
		return manejoRepository.save(obj);  
	}
	
	// UPDATE
		public Manejo update(Manejo obj) {
			Manejo newObj = find(obj.getId());
			newObj.setDataHoraManejo(obj.getDataHoraManejo());
			newObj.setTipoManejo(obj.getTipoManejo());
			newObj.setObservacoes(obj.getObservacoes());
			return manejoRepository.save(newObj);
		}

		// DELETE
		public void delete(Integer id) {
			find(id);
			try {
				manejoRepository.deleteById(id);
			} catch (DataIntegrityViolationException e) {
				throw new DataIntegrityViolationException("Não é possivel excluir este registro!");
			}
		}

	

}
