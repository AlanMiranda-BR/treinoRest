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
import com.fish2048.training.services.BiometriaService;

/**
 * @author Pedro Lz
 *
 */
@RestController
@RequestMapping(value = "/biometrias")
public class BiometriaResource {

	@Autowired
	private BiometriaService biometriaService;

	@GetMapping
	public ResponseEntity<List<Biometria>> findAll() {
		List<Biometria> biometria = biometriaService.findAll();
		return ResponseEntity.ok().body(biometria);
	}
	
	// /biometrias/1
	@GetMapping(value = "/{id}")
	public ResponseEntity<Biometria> find(@PathVariable Integer id) {
		Biometria biometria = biometriaService.find(id);
		return ResponseEntity.ok().body(biometria);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Biometria biometria) {
		biometria = biometriaService.insert(biometria);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Biometria biometria, @PathVariable Integer id) {
		biometria.setId(id);
		biometria = biometriaService.update(biometria);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		biometriaService.delete(id);
		return ResponseEntity.noContent().build();
	}
}