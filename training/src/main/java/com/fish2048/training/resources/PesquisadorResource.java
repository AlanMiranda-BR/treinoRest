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

import com.fish2048.training.domain.Pesquisador;
import com.fish2048.training.services.PesquisadorService;

/**
 * @author Wellinton Camboim
 *
 */
@RestController
@RequestMapping(value = "/pesquisadores")
public class PesquisadorResource {
	@Autowired
	private PesquisadorService pesquisadorService;
	
	@GetMapping
	public ResponseEntity<List<Pesquisador>> findAll() {
		List<Pesquisador> pesquisador = pesquisadorService.findAll();
		return ResponseEntity.ok().body(pesquisador);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Pesquisador> find(@PathVariable Integer id) {
		Pesquisador pesquisador = pesquisadorService.find(id);
		return ResponseEntity.ok().body(pesquisador);
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Pesquisador pesquisador) {
		pesquisador = pesquisadorService.insert(pesquisador);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pesquisador.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Pesquisador pesquisador, @PathVariable Integer id) {
		pesquisador.setId(id);
		pesquisador = pesquisadorService.update(pesquisador);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		pesquisadorService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
