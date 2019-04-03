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

import com.fish2048.training.domain.Piscicultor;
import com.fish2048.training.services.PiscicultorService;

/**
 * @author Jhon
 *
 */
@RestController
@RequestMapping(value = "/piscicultores")
public class PiscicultorResource {
	@Autowired
	private PiscicultorService piscicultorService;

	@GetMapping
	public ResponseEntity<List<Piscicultor>> findAll() {
		List<Piscicultor> piscicultor = piscicultorService.findAll();
		return ResponseEntity.ok().body(piscicultor);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Piscicultor> find(@PathVariable Integer id) {
		Piscicultor piscicultor = piscicultorService.find(id);
		return ResponseEntity.ok().body(piscicultor);
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Piscicultor piscicultor) {
		piscicultor = piscicultorService.insert(piscicultor);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(piscicultor.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Piscicultor piscicultor, @PathVariable Integer id) {
		piscicultor.setId(id);
		piscicultor = piscicultorService.update(piscicultor);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		piscicultorService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
