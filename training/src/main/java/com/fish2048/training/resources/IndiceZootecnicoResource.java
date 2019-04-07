package com.fish2048.training.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fish2048.training.domain.IndiceZootecnico;
import com.fish2048.training.services.IndiceZootecnicoService;

/**
 * @author Pedro Lz
 *
 */
@RestController
@RequestMapping(value = "/indicesZootecnicos")
public class IndiceZootecnicoResource {

	@Autowired
	private IndiceZootecnicoService indiceZootecnicoService;

	@GetMapping
	public ResponseEntity<List<IndiceZootecnico>> findAll() {
		List<IndiceZootecnico> indiceZootecnico = indiceZootecnicoService.findAll();
		return ResponseEntity.ok().body(indiceZootecnico);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<IndiceZootecnico> find(@PathVariable Integer id) {
		IndiceZootecnico indiceZootecnico = indiceZootecnicoService.find(id);
		return ResponseEntity.ok().body(indiceZootecnico);
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody IndiceZootecnico indiceZootecnico) {
		indiceZootecnico = indiceZootecnicoService.insert(indiceZootecnico);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody IndiceZootecnico indiceZootecnico, @PathVariable Integer id) {
		indiceZootecnico.setId(id);
		indiceZootecnico = indiceZootecnicoService.update(indiceZootecnico);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		indiceZootecnicoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
