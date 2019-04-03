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

import com.fish2048.training.domain.EspeciePeixe;
import com.fish2048.training.services.EspeciePeixeService;

/**
 * @author Vitória Ramos
 *
 */
@RestController
@RequestMapping(value = "/especies")
public class EspeciePeixeResource {
	@Autowired
	private EspeciePeixeService especiePeixeService;

	@GetMapping
	public ResponseEntity<List<EspeciePeixe>> findAll() {
		List<EspeciePeixe> especiePeixe = especiePeixeService.findAll();
		return ResponseEntity.ok().body(especiePeixe);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<EspeciePeixe> find(@PathVariable Integer id) {
		EspeciePeixe especiePeixe = especiePeixeService.find(id);
		return ResponseEntity.ok().body(especiePeixe);
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody EspeciePeixe especiePeixe) {
		especiePeixe = especiePeixeService.insert(especiePeixe);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(especiePeixe.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody EspeciePeixe especiePeixe, @PathVariable Integer id) {
		especiePeixe.setId(id);
		especiePeixe = especiePeixeService.update(especiePeixe);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		especiePeixeService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
