package com.fish2048.training.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fish2048.training.domain.Pesquisador;
import com.fish2048.training.services.PesquisadorService;

@RestController
@RequestMapping(value = "/pesquisadores")
public class PesquisadorResource {
	@Autowired
	private PesquisadorService pesquisadorService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pesquisador> find(@PathVariable Integer id){
		Pesquisador obj = pesquisadorService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Pesquisador obj)  {
		obj = pesquisadorService.insert(obj);
		return ResponseEntity.noContent().build();
		
	}
}
