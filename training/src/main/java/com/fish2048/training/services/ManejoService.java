package com.fish2048.training.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.fish2048.training.domain.Manejo;
import com.fish2048.training.domain.ManejoPK;
import com.fish2048.training.domain.Povoamento;
import com.fish2048.training.repositories.ManejoRepository;

/**
 * @author Gabriel Mauro
 *
 */
@Service
public class ManejoService {
	@Autowired
	private ManejoRepository manejoRepository;

	@Autowired
	private PovoamentoService povoamentoService;

	// READS
	public List<Manejo> findAll() {
		List<Manejo> manejo = manejoRepository.findAll();
		return manejo;
	}

	public List<Manejo> find(@PathVariable Integer id, Date dataHora) {
		List<Manejo> manejo = manejoRepository.findByIdCompoused(id);
		return manejo;
	}

	// CREATES
	public Manejo insert(Manejo manejo, Integer id) {
		Date date = new Date(); // pega a data do sistema
		Povoamento povoamento = povoamentoService.find(id);
		Manejo newManejo = new Manejo(new ManejoPK(povoamento, date), manejo.getTipoManejo(), manejo.getObservacoes());
		return manejoRepository.save(newManejo);
	}

	// UPDATES
	public Manejo update(@RequestBody Manejo manejo, @PathVariable Integer id, Date dataHora) {
		System.out.println("ID -> " + id + "DATA/HORA -> "+ dataHora);
		Manejo newManejo = new Manejo(findManejoPK(id, dataHora), manejo.getTipoManejo(), manejo.getObservacoes());
		//newManejo.setId(findManejoPK(id, dataHora));
		//newManejo.setTipoManejo(manejo.getTipoManejo());
		//newManejo.setObservacoes(manejo.getObservacoes());
		return manejoRepository.save(newManejo);
	}

	// DELETES - DESATIVADO POR ENQUANTO
//	public void delete(@PathVariable Integer id, Date dataHora) {
//		find(id, dataHora);
//		try {
//			manejoRepository.delete(find(id, dataHora));
//		} catch (DataIntegrityViolationException e) {
//			throw new DataIntegrityViolationException("Não é possivel excluir este registro!");
//		}
//	}
	
	// AUXILIARES
	private ManejoPK findManejoPK(Integer id, Date dataHora) {
		Povoamento povoamento = povoamentoService.find(id);
		ManejoPK manejoPK = new ManejoPK(povoamento, dataHora);
		return manejoPK;
	}

}
