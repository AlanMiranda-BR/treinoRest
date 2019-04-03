package com.fish2048.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fish2048.training.domain.LotePeixe;
import com.fish2048.training.repositories.LotePeixeRepository;

/**
 * @author Vitória Ramos
 *
 */
@Service
public class LotePeixeService {

	@Autowired
	private LotePeixeRepository lotePeixeRepository;

	// CREATES
	public LotePeixe insert(LotePeixe lotePeixe) {
		lotePeixe.setId(null);
		return lotePeixeRepository.save(lotePeixe);
	}

	// READS
	public List<LotePeixe> findAll() {
		List<LotePeixe> lotePeixe = lotePeixeRepository.findAll();
		return lotePeixe;
	}

	public LotePeixe find(Integer id) {
		Optional<LotePeixe> lotePeixe = lotePeixeRepository.findById(id);
		return lotePeixe.orElse(null);
	}

	// UPDATES
	public LotePeixe update(LotePeixe lotePeixe) {
		LotePeixe newLotePeixe = find(lotePeixe.getId());
		newLotePeixe.setBiomassa(lotePeixe.getBiomassa());
		newLotePeixe.setDataLote(lotePeixe.getDataLote());
		newLotePeixe.setPesoMedio(lotePeixe.getPesoMedio());
		newLotePeixe.setQtdTotal(lotePeixe.getQtdTotal());
		return lotePeixeRepository.save(newLotePeixe);
	}

	// DELETES
	public void delete(Integer id) {
		find(id);
		try {
			lotePeixeRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel excluir este registro!");
		}
	}

}
