package com.rvr.sistematestesgpus.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rvr.sistematestesgpus.entities.views.DadosTeste;
import com.rvr.sistematestesgpus.services.TestesGpuService;

@RestController
@RequestMapping(value = "/dadosteste")
public class DadosTesteResource {
	
	@Autowired
	private TestesGpuService service;
	
	@GetMapping
	public ResponseEntity<List<DadosTeste>> findAll() {
		
		return ResponseEntity.ok().body(service.findAllView()); 
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<DadosTeste> findById(@PathVariable Integer id) {
	
		return ResponseEntity.ok().body(service.findByIdView(id));
	}
	
}
