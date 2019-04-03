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

import com.fish2048.training.domain.Autorias;
import com.fish2048.training.services.AutoriasService;

/**
 * @author Wellinton Camboim
 * @Todo Concluido a implementação da classe
 */
@RestController
@RequestMapping(value = "/autorias")
public class AutoriasResource {
	@Autowired
	private AutoriasService autoriasService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Autorias> find(@PathVariable Integer id) {
		Autorias autorias = autoriasService.find(id);
		return ResponseEntity.ok().body(autorias);
	}

	@GetMapping
	public ResponseEntity<List<Autorias>> findAll(){
		List<Autorias> autorias = autoriasService.findAll();
		return ResponseEntity.ok().body(autorias);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Autorias obj) {
		obj = autoriasService.insert(obj);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Autorias autorias, @PathVariable Integer id) {
		autorias.setId(id);
		autorias = autoriasService.update(autorias);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		autoriasService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
