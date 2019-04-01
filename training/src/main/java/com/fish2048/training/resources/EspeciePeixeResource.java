package com.fish2048.training.resources;
//reup
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fish2048.training.domain.EspeciePeixe;
import com.fish2048.training.services.EspeciePeixeService;

@RestController
@RequestMapping(value = "/especies")
public class EspeciePeixeResource {
	@Autowired
	private EspeciePeixeService especiePeixeService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<EspeciePeixe> find(@PathVariable Integer id) {
		EspeciePeixe obj = especiePeixeService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody EspeciePeixe obj){
		obj = especiePeixeService.insert(obj);
		return ResponseEntity.noContent().build();
	}
}
