package com.fish2048.training.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fish2048.training.domain.Viveiro;
import com.fish2048.training.services.ViveiroService;

/**
 * @author Jhon
 *
 */
@RestController
@RequestMapping(value = "/viveiros")
public class ViveiroResource {

	@Autowired
	private ViveiroService viveroService;

	@GetMapping
	public ResponseEntity<List<Viveiro>> findAll() {
		List<Viveiro> viveiro = viveroService.findAll();
		return ResponseEntity.ok().body(viveiro);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Viveiro> find(@PathVariable Integer id) {
		Viveiro viveiro = viveroService.find(id);
		return ResponseEntity.ok().body(viveiro);
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Viveiro viveiro) {
		viveiro = viveroService.insert(viveiro);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(viveiro.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@PostMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Viveiro viveiro, @PathVariable Integer id) {
		viveiro.setId(id);
		viveiro = viveroService.update(viveiro);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		viveroService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
