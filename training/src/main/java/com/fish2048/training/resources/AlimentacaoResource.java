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
import com.fish2048.training.domain.Alimentacao;
import com.fish2048.training.services.AlimentacaoService;

/**
 * Criado por Rafael Silva Neukirchen
 */

@RestController
@RequestMapping(value = "/Alimentacao")
public class AlimentacaoResource {

	@Autowired
	private AlimentacaoService alimentacaoService;
	
	@GetMapping
	public ResponseEntity<List<Alimentacao>> findAll() {
		List<Alimentacao> obj = alimentacaoService.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Alimentacao> find(@PathVariable Integer id) {
		Alimentacao obj = alimentacaoService.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Alimentacao obj) {
		obj = alimentacaoService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Alimentacao obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = alimentacaoService.update(obj);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		alimentacaoService.delete(id);
		return ResponseEntity.noContent().build();
	}
		
}
