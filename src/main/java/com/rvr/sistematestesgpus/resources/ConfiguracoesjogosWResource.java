package com.rvr.sistematestesgpus.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rvr.sistematestesgpus.entities.views.ConfiguracoesJogosW;
import com.rvr.sistematestesgpus.services.ConfiguracoesJogosService;

@RestController
@RequestMapping(value = "/configuracoesjogosw")
public class ConfiguracoesjogosWResource {
	
	@Autowired
	private ConfiguracoesJogosService service;
	
	@GetMapping
	public ResponseEntity<List<ConfiguracoesJogosW>> findAll() {
		
		return ResponseEntity.ok().body(service.findAllView()); 
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ConfiguracoesJogosW> findById(@PathVariable Integer id) {
	
		return ResponseEntity.ok().body(service.findByIdView(id));
	}
	
}
