package com.fish2048.training.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fish2048.training.domain.Autorias;
import com.fish2048.training.services.AutoriasService;

@RestController
@RequestMapping(value = "/autorias")
public class AutoriasResource {
	@Autowired
	private AutoriasService autoriasService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Autorias> find(@PathVariable Integer id){
		Autorias obj = autoriasService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Autorias obj) {
		obj = autoriasService.insert(obj);
		return ResponseEntity.noContent().build();
	}
}
