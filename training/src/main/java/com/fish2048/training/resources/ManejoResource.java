package com.fish2048.training.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fish2048.training.domain.Manejo;
import com.fish2048.training.services.ManejoService;

@RestController
@RequestMapping(value = "/manejos")
public class ManejoResource {
	@Autowired
	private ManejoService manejoService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Manejo> find(@PathVariable Integer id){
		Manejo obj = manejoService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Manejo obj){
		obj = manejoService.insert(obj);
		return ResponseEntity.noContent().build();
	}
	
}
