package com.rvr.sistematestesgpus.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rvr.sistematestesgpus.entities.views.Processador;
import com.rvr.sistematestesgpus.services.ProcessadoresService;

@RestController
@RequestMapping(value = "/processadoresw")
public class ProcessadoresWResource {
	
	@Autowired
	private ProcessadoresService service;
	
	@GetMapping
	public ResponseEntity<List<Processador>> findAll() {
		
		return ResponseEntity.ok().body(service.findAllView()); 
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Processador> findById(@PathVariable Integer id) {
	
		return ResponseEntity.ok().body(service.findByIdView(id));
	}
}
