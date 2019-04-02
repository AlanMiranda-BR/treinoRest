package com.fish2048.training.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fish2048.training.domain.LotePeixe;
import com.fish2048.training.services.LotePeixeService;

@RestController
@RequestMapping(value = "/lotes")
public class LotePeixeResource {
	@Autowired
	private LotePeixeService lotePeixeService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<LotePeixe> find(@PathVariable Integer id) {
		LotePeixe obj = lotePeixeService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody LotePeixe obj){
		obj = lotePeixeService.insert(obj);
		return ResponseEntity.noContent().build();
	}

}
