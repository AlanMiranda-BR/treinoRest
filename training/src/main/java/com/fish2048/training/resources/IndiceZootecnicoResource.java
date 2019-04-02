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

@RestController
@RequestMapping(value = "/indiceZootecnicos")
public class IndiceZootecnicoResource {
	
	@Autowired
	private IndiceZootecnicoService indiceZootecnicoService;
	
	@GetMapping
	public ResponseEntity<List<IndiceZootecnico>> findAll() {
		List<IndiceZootecnico> obj = indiceZootecnicoService.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<IndiceZootecnico> find(@PathVariable Integer id) {
		IndiceZootecnico obj = indiceZootecnicoService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody IndiceZootecnico obj) {
		obj = indiceZootecnicoService.insert(obj);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody IndiceZootecnico obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = indiceZootecnicoService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		indiceZootecnicoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
