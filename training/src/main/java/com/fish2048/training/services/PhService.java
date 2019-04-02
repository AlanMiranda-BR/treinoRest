package com.fish2048.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fish2048.training.domain.Ph;
import com.fish2048.training.repositories.PhRepository;



@Service
public class PhService {
	@Autowired
	private PhRepository phRepository;
	
	//FIND ALL
	public List<Ph> findAll() {
		return phRepository.findAll();
	}
	
	//FIND BY ID
	public Ph find(Integer id ) {
		Optional<Ph> obj = phRepository.findById(id);
		return obj.orElse(null);
	}
	
	//INSERT
	public Ph insert(Ph obj) {
		obj.setId(null);
		return phRepository.save(obj);
	}
	
	// UPDATE
	public Ph update(Ph obj) {
		Ph newObj = find(obj.getId());
		newObj.setAfericaoPh(obj.getAfericaoPh());
		return phRepository.save(newObj);
	}

	// DELETE
	public void delete(Integer id) {
		find(id);
		try {
			phRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel excluir este registro!");
		}
	}
	

}
