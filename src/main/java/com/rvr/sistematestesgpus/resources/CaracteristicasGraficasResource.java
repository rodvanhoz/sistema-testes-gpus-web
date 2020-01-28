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

import com.rvr.sistematestesgpus.entities.tables.CaracteristicasGraficas;
import com.rvr.sistematestesgpus.services.CaracteristicasGraficasService;

@RestController
@RequestMapping(value = "/caracteristicasgraficas")
public class CaracteristicasGraficasResource {
	
	@Autowired
	private CaracteristicasGraficasService service;
	
	@GetMapping
	public ResponseEntity<List<CaracteristicasGraficas>> findAll() {
		
		return ResponseEntity.ok().body(service.findAll()); 
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CaracteristicasGraficas> findById(@PathVariable Integer id) {
	
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<CaracteristicasGraficas> insert(@RequestBody CaracteristicasGraficas obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCaracGrafica()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CaracteristicasGraficas> update(@PathVariable Integer id, @RequestBody CaracteristicasGraficas obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
