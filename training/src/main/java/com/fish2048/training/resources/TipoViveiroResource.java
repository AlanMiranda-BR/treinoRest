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

import com.fish2048.training.domain.TipoViveiro;
import com.fish2048.training.services.TipoViveiroService;


/**
 * @author Gabriel Mauro
 *
 */
@RestController
@RequestMapping(value = "/tipoViveiros")
public class TipoViveiroResource {
	
	@Autowired
	private TipoViveiroService tipoViveiroService;
	
	@GetMapping
	public ResponseEntity<List<TipoViveiro>> findAll() {
		List<TipoViveiro> tipoViveiro = tipoViveiroService.findAll();
		return ResponseEntity.ok().body(tipoViveiro);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<TipoViveiro> find(@PathVariable Integer id) {
		TipoViveiro tipoViveiro = tipoViveiroService.find(id);
		return ResponseEntity.ok().body(tipoViveiro);
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody TipoViveiro tipoViveiro) {
		tipoViveiro = tipoViveiroService.insert(tipoViveiro);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tipoViveiro.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody TipoViveiro tipoViveiro, @PathVariable Integer id) {
		tipoViveiro.setId(id);
		tipoViveiro = tipoViveiroService.update(tipoViveiro);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		tipoViveiroService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
