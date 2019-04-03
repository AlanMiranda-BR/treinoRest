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

import com.fish2048.training.domain.LotePeixe;
import com.fish2048.training.services.LotePeixeService;

/**
 * @author Vitória Ramos
 *
 */
@RestController
@RequestMapping(value = "/lotes")
public class LotePeixeResource {
	@Autowired
	private LotePeixeService lotePeixeService;

	@GetMapping
	public ResponseEntity<List<LotePeixe>> findAll() {
		List<LotePeixe> lotePeixe = lotePeixeService.findAll();
		return ResponseEntity.ok().body(lotePeixe);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<LotePeixe> find(@PathVariable Integer id) {
		LotePeixe lotePeixe = lotePeixeService.find(id);
		return ResponseEntity.ok().body(lotePeixe);
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody LotePeixe lotePeixe) {
		lotePeixe = lotePeixeService.insert(lotePeixe);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(lotePeixe.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody LotePeixe lotePeixe, @PathVariable Integer id) {
		lotePeixe.setId(id);
		lotePeixe = lotePeixeService.update(lotePeixe);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		lotePeixeService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
