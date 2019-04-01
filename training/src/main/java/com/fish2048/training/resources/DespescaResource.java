package com.fish2048.training.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fish2048.training.domain.Despesca;
import com.fish2048.training.services.DespescaService;

@RestController
@RequestMapping(value = "/despescas")
public class DespescaResource {
	@Autowired
	private DespescaService despescaService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Despesca> find(@PathVariable Integer id){
		Despesca obj = despescaService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Despesca obj){
		despescaService.insert(obj);
		return ResponseEntity.noContent().build();
	}
}
