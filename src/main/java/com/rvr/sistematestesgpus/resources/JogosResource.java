package com.rvr.sistematestesgpus.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rvr.sistematestesgpus.entities.tables.Jogos;
import com.rvr.sistematestesgpus.services.JogosService;

@RestController
@RequestMapping(value = "/jogos")
public class JogosResource {
	
	@Autowired
	private JogosService service;
	
	@GetMapping
	public ResponseEntity<List<Jogos>> findAll() {
		
		return ResponseEntity.ok().body(service.findAll()); 
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Jogos> findById(@PathVariable Integer id) {
	
		return ResponseEntity.ok().body(service.findById(id));
	}
	
}
