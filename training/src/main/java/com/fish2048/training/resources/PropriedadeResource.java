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

import com.fish2048.training.domain.Propriedade;
import com.fish2048.training.services.PropriedadeService;

/**
 * @author Jhon
 *
 */
@RestController
@RequestMapping(value = "/propriedades") // dizer o endereco
public class PropriedadeResource {

	@Autowired
	private PropriedadeService propriedadeService;

	@GetMapping
	public ResponseEntity<List<Propriedade>> findAll() {
		return ResponseEntity.ok().body(propriedadeService.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Propriedade> find(@PathVariable Integer id) { // PathVariable faz o caminho para uri da
																		// requisição no caso o /id
		Propriedade obj = propriedadeService.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping 																// não precisa de um path pois é um metodo de insercao os dados estarao no corpo
	public ResponseEntity<Void> insert(@RequestBody Propriedade obj) { 			// o obj a ser enviado esta no corpo da mensagem
		obj = propriedadeService.insert(obj); 									// ele espera um objeto como argumento nesse caso o obj
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Propriedade obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = propriedadeService.update(obj);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		propriedadeService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
