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

import com.fish2048.training.domain.Parametro;
import com.fish2048.training.services.ParametroService;

/**
 * @author Pedro Lz
 *
 */
@RestController
@RequestMapping(value = "/parametros")
public class ParametroResource {
	@Autowired
	private ParametroService parametroService;

	@GetMapping
	public ResponseEntity<List<Parametro>> findAll() {
		List<Parametro> parametro = parametroService.findAll();
		return ResponseEntity.ok().body(parametro);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Parametro> find(@PathVariable Integer id) {
		Parametro parametro = parametroService.find(id);
		return ResponseEntity.ok().body(parametro);
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Parametro parametro) {
		parametro = parametroService.insert(parametro);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(parametro.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Parametro parametro, @PathVariable Integer id) {
		parametro.setId(id);
		parametro = parametroService.update(parametro);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		parametroService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
