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

import com.fish2048.training.domain.Povoamento;
import com.fish2048.training.services.PovoamentoService;

/**
 * @author Alan Felipe Miranda Controller reponsável por atender as requisições
 *         HTTP do cliente e retornar as respostas.
 */
@RestController
@RequestMapping(value = "/povoamento")
public class PovoamentoResource {

	@Autowired
	private PovoamentoService povoamentoService;

	@GetMapping
	public ResponseEntity<List<Povoamento>> findAll() {
		List<Povoamento> obj = povoamentoService.findAll();
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Povoamento> find(@PathVariable Integer id) {
		Povoamento obj = povoamentoService.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Povoamento obj) {
		obj = povoamentoService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Povoamento obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = povoamentoService.update(obj);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		povoamentoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
