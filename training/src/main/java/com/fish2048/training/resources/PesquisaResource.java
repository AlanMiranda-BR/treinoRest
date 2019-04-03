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

import com.fish2048.training.domain.Pesquisa;
import com.fish2048.training.services.PesquisaService;

/**
 * @author Wellinton Camboim
 *
 */
@RestController
@RequestMapping(value = "/pesquisas")
public class PesquisaResource {
	@Autowired
	private PesquisaService pesquisaService;

	@GetMapping
	public ResponseEntity<List<Pesquisa>> findAll() {
		List<Pesquisa> pesquisa = pesquisaService.findAll();
		return ResponseEntity.ok().body(pesquisa);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Pesquisa> find(@PathVariable Integer id) {
		Pesquisa pesquisa = pesquisaService.find(id);
		return ResponseEntity.ok().body(pesquisa);
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Pesquisa pesquisa) {
		pesquisa = pesquisaService.insert(pesquisa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pesquisa.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Pesquisa pesquisa, @PathVariable Integer id) {
		pesquisa.setId(id);
		pesquisa = pesquisaService.update(pesquisa);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		pesquisaService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
