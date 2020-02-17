package com.rvr.sistematestesgpus.resources;

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

import com.rvr.sistematestesgpus.entities.tables.Configuracoes;
import com.rvr.sistematestesgpus.services.ConfiguracoesService;

@RestController
@RequestMapping(value = "/configuracoes")
public class ConfiguracoesResource {
	
	@Autowired
	private ConfiguracoesService service;
	
	@GetMapping
	public ResponseEntity<List<Configuracoes>> findAll() {
		
		return ResponseEntity.ok().body(service.findAll()); 
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Configuracoes> findById(@PathVariable Integer id) {
	
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Configuracoes> insert(@RequestBody Configuracoes obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdConfiguracao()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Configuracoes> update(@PathVariable Integer id, @RequestBody Configuracoes obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
