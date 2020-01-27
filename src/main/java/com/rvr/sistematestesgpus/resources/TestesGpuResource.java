package com.rvr.sistematestesgpus.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rvr.sistematestesgpus.entities.tables.TestesGpu;
import com.rvr.sistematestesgpus.services.TestesGpuService;

@RestController
@RequestMapping(value = "/testesgpu")
public class TestesGpuResource {
	
	@Autowired
	private TestesGpuService service;
	
	@GetMapping
	public ResponseEntity<List<TestesGpu>> findAll() {
		
		return ResponseEntity.ok().body(service.findAll()); 
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TestesGpu> findById(@PathVariable Integer id) {
	
		return ResponseEntity.ok().body(service.findById(id));
	}
	
}
