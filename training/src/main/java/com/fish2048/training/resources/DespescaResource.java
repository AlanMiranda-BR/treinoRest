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

import com.fish2048.training.domain.Despesca;
import com.fish2048.training.services.DespescaService;

/**
 * @author Alan Felipe Miranda
 *
 */
@RestController
@RequestMapping(value = "/despescas")
public class DespescaResource {
	@Autowired
	private DespescaService despescaService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Despesca> find(@PathVariable Integer id) {
		Despesca despesca = despescaService.find(id);
		return ResponseEntity.ok().body(despesca);
	}

	@GetMapping
	public ResponseEntity<List<Despesca>> findAll() {
		return ResponseEntity.ok().body(despescaService.findAll());
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Despesca despesca) {
		despescaService.insert(despesca);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Despesca despesca, @PathVariable Integer id) {
		despesca.setId(id);
		despescaService.update(despesca);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		despescaService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
