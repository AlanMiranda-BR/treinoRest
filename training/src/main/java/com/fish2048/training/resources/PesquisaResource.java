package com.fish2048.training.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fish2048.training.domain.Pesquisa;
import com.fish2048.training.services.PesquisaService;

@RestController
@RequestMapping(value = "/pesquisas")
public class PesquisaResource {
	@Autowired
	private PesquisaService pesquisaService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pesquisa> find(@PathVariable Integer id){
		Pesquisa obj = pesquisaService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	@PostMapping
	public ResponseEntity<Void> insert (@RequestBody Pesquisa obj){
		obj = pesquisaService.insert(obj);
		return ResponseEntity.noContent().build();
	}
}
