package com.fish2048.training.resources;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fish2048.training.domain.Manejo;
import com.fish2048.training.services.ManejoService;

/**
 * @author Gabriel Mauro
 *
 */
@RestController
@RequestMapping(value = "/manejos")
public class ManejoResource {
	@Autowired
	private ManejoService manejoService;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	@GetMapping
	public ResponseEntity<List<Manejo>> findAll() {
		List<Manejo> manejo = manejoService.findAll();
		return ResponseEntity.ok().body(manejo);
	}

	@GetMapping(value = "/id")
	public ResponseEntity<List<Manejo>> find(@RequestParam(value = "id", defaultValue = "0") Integer id,
			@RequestParam(value = "dataHora", defaultValue = "12/04/2018 14:40") String dataHora) throws ParseException {
		List<Manejo> manejo = manejoService.find(id, sdf.parse(dataHora));
		System.out.println("IMPRIMINDO MANEJO -> " );
		return ResponseEntity.ok().body(manejo);
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Manejo manejo) {
		manejo = manejoService.insert(manejo, 1);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(manejo.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping
	public ResponseEntity<Void> update(@RequestBody Manejo manejo,
			@RequestParam(value = "id", defaultValue = "0") Integer id,
			@RequestParam(value = "dataHora", defaultValue = "12/04/2018 14:40") Date dataHora) throws ParseException {
		manejo = manejoService.update(manejo, id, dataHora);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping
	public ResponseEntity<String> delete() {
		return ResponseEntity.badRequest().body("Exclusão de Manejos não faz parte das regras de negócio");
	}

}
