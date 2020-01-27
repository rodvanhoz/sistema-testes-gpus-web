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

import com.rvr.sistematestesgpus.entities.tables.ConfiguracoesJogos;
import com.rvr.sistematestesgpus.services.ConfiguracoesJogosService;
import com.rvr.sistematestesgpus.services.ConfiguracoesService;
import com.rvr.sistematestesgpus.services.JogosService;

@RestController
@RequestMapping(value = "/configuracoesjogos")
public class ConfiguracoesJogosResource {
	
	@Autowired
	private ConfiguracoesJogosService service;
	
	@Autowired
	private ConfiguracoesService configuracoesService;
	
	@Autowired
	private JogosService jogosService;
	
	@GetMapping
	public ResponseEntity<List<ConfiguracoesJogos>> findAll() {
		
		return ResponseEntity.ok().body(service.findAll()); 
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ConfiguracoesJogos> findById(@PathVariable Integer id) {
	
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	@PostMapping(value = "/{idJogo}/{idConfiguracao}")
	public ResponseEntity<ConfiguracoesJogos> insert(@PathVariable Integer idJogo, @PathVariable Integer idConfiguracao) {
		ConfiguracoesJogos obj = new ConfiguracoesJogos(jogosService.findById(idJogo), configuracoesService.findById(idConfiguracao));
		
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdConfiguracaoJogos()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ConfiguracoesJogos> update(@PathVariable Integer id, @RequestBody ConfiguracoesJogos obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
