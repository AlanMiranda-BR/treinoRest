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

import com.fish2048.training.domain.Biometria;
import com.fish2048.training.domain.Povoamento;
import com.fish2048.training.services.BiometriaService;

@RestController
@RequestMapping(value = "/biometrias")
public class BiometriaResource {

	@Autowired
	private BiometriaService biometriaService;

	@GetMapping
	public ResponseEntity<List<Biometria>> findAll() {
		List<Biometria> obj = biometriaService.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	// /biometrias/1
	@GetMapping(value = "/{id}")
	public ResponseEntity<Biometria> find(@PathVariable Integer id) {
		Biometria obj = biometriaService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Biometria obj) {
		obj = biometriaService.insert(obj);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Biometria obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = biometriaService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		biometriaService.delete(id);
		return ResponseEntity.noContent().build();
	}
}