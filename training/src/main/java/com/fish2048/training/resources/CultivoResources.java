package com.fish2048.training.resources;

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

import com.fish2048.training.domain.Cultivo;
import com.fish2048.training.services.CultivoService;

@RestController
@RequestMapping(value = "/cultivos")
public class CultivoResources {
	@Autowired
	private CultivoService cultivoService;
	
	@GetMapping
	public ResponseEntity<List<Cultivo>> findAll(){
		return ResponseEntity.ok().body(cultivoService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cultivo> find(@PathVariable Integer id){
		return ResponseEntity.ok().body(cultivoService.find(id));
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Cultivo obj){
		obj = cultivoService.insert(obj);
		return ResponseEntity.created(null).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Cultivo obj, @PathVariable Integer id){
		obj.setId(id);
		cultivoService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		cultivoService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
