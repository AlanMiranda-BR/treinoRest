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
import com.fish2048.training.domain.CustoRacao;
import com.fish2048.training.services.CustoRacaoService;

/**
 * @author Rafael Silva Neukirchen
 *
 */
@RestController
@RequestMapping(value = "/custoracoes")
public class CustoRacaoResource {

	@Autowired
	private CustoRacaoService custoRacaoService;

	@GetMapping
	public ResponseEntity<List<CustoRacao>> findAll() {
		List<CustoRacao> custoRacao = custoRacaoService.findAll();
		return ResponseEntity.ok().body(custoRacao);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<CustoRacao> find(@PathVariable Integer id) {
		CustoRacao custoRacao = custoRacaoService.find(id);
		return ResponseEntity.ok().body(custoRacao);
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody CustoRacao custoRacao) {
		custoRacao = custoRacaoService.insert(custoRacao);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(custoRacao.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody CustoRacao custoRacao, @PathVariable Integer id) {
		custoRacao.setId(id);
		custoRacao = custoRacaoService.update(custoRacao);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		custoRacaoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
