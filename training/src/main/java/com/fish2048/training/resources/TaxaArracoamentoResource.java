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

import com.fish2048.training.domain.TaxaArracoamento;
import com.fish2048.training.services.TaxaArracoamentoService;

/**
 * @author Wellinton Camboim
 *
 */
@RestController
@RequestMapping(value = "/taxasArracoamentos")
public class TaxaArracoamentoResource {
	@Autowired
	private TaxaArracoamentoService taxaArracoamentoService;

	@GetMapping
	public ResponseEntity<List<TaxaArracoamento>> findAll() {
		List<TaxaArracoamento> taxaArracoamento = taxaArracoamentoService.findAll();
		return ResponseEntity.ok().body(taxaArracoamento);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<TaxaArracoamento> find(@PathVariable Integer id) {
		TaxaArracoamento taxaArracoamento = taxaArracoamentoService.find(id);
		return ResponseEntity.ok().body(taxaArracoamento);
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody TaxaArracoamento taxaArracoamento) {
		taxaArracoamento = taxaArracoamentoService.insert(taxaArracoamento);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(taxaArracoamento.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody TaxaArracoamento taxaArracoamento, @PathVariable Integer id) {
		taxaArracoamento.setId(id);
		taxaArracoamento = taxaArracoamentoService.update(taxaArracoamento);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		taxaArracoamentoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
