package com.rvr.sistematestesgpus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rvr.sistematestesgpus.entities.tables.ConfiguracoesJogos;
import com.rvr.sistematestesgpus.repositories.ConfiguracoesJogosRepository;

@Service
public class ConfiguracoesJogosService {

	@Autowired
	private ConfiguracoesJogosRepository repository;
	
	public List<ConfiguracoesJogos> findAll() {
		return repository.findAll();
	}
	
	public ConfiguracoesJogos findById(Integer id) {
		Optional<ConfiguracoesJogos> obj = repository.findById(id); 
		return obj.get();
	}
}
