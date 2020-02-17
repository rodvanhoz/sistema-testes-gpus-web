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

import com.rvr.sistematestesgpus.entities.tables.Gpus;
import com.rvr.sistematestesgpus.services.GpusService;

@RestController
@RequestMapping(value = "/gpus")
public class GpusResource {
	
	@Autowired
	private GpusService service;
	
	@GetMapping
	public ResponseEntity<List<Gpus>> findAll() {
		
		return ResponseEntity.ok().body(service.findAll()); 
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Gpus> findById(@PathVariable Integer id) {
	
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Gpus> insert(@RequestBody Gpus obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdGpu()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Gpus> update(@PathVariable Integer id, @RequestBody Gpus obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
