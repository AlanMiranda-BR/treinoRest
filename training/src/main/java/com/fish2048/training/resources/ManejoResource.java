package com.fish2048.training.resources;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fish2048.training.domain.Manejo;
import com.fish2048.training.services.ManejoService;

/**
 * @author Gabriel Mauro
 *
 */
@RestController
@RequestMapping(value = "/manejos")
public class ManejoResource {
	@Autowired
	private ManejoService manejoService;

	@GetMapping
	public ResponseEntity<List<Manejo>> findAll() {
		List<Manejo> manejo = manejoService.findAll();
		return ResponseEntity.ok().body(manejo);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Manejo> find(@PathVariable Integer id) {
		Manejo manejo = manejoService.find(id);
		return ResponseEntity.ok().body(manejo);
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Manejo manejo) {
		manejo = manejoService.insert(manejo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(manejo.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Manejo manejo, @PathVariable Integer id) {
		manejo.setId(id);
		manejo = manejoService.update(manejo);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		manejoService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
