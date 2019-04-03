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

import com.fish2048.training.domain.Publicacao;
import com.fish2048.training.services.PublicacaoService;

/**
 * @author Wellinton Camboim
 *
 */
@RestController
@RequestMapping(value = "/publicacoes")
public class PublicacaoResource {
	@Autowired
	private PublicacaoService publicacaoService;

	@GetMapping
	public ResponseEntity<List<Publicacao>> findAll() {
		List<Publicacao> publicacao = publicacaoService.findAll();
		return ResponseEntity.ok().body(publicacao);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Publicacao> find(@PathVariable Integer id) {
		Publicacao publicacao = publicacaoService.find(id);
		return ResponseEntity.ok().body(publicacao);
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Publicacao publicacao) {
		publicacao = publicacaoService.insert(publicacao);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(publicacao.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Publicacao publicacao, @PathVariable Integer id) {
		publicacao.setId(id);
		publicacao = publicacaoService.update(publicacao);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		publicacaoService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
