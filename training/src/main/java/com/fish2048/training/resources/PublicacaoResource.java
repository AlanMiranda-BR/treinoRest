package com.fish2048.training.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fish2048.training.domain.Publicacao;
import com.fish2048.training.services.PublicacaoService;

@RestController
@RequestMapping(value = "/publicacoes")
public class PublicacaoResource {
	@Autowired
	private PublicacaoService publicacaoService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Publicacao> find(@PathVariable Integer id){
		Publicacao obj = publicacaoService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Publicacao obj){
		obj = publicacaoService.insert(obj);
		return ResponseEntity.noContent().build();
	
	}

}
