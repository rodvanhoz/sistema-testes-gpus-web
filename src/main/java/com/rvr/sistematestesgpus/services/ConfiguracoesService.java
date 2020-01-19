package com.rvr.sistematestesgpus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rvr.sistematestesgpus.entities.tables.Configuracoes;
import com.rvr.sistematestesgpus.repositories.ConfiguracoesRepository;

@Service
public class ConfiguracoesService {

	@Autowired
	private ConfiguracoesRepository repository;
	
	public List<Configuracoes> findAll() {
		return repository.findAll();
	}
	
	public Configuracoes findById(Integer id) {
		Optional<Configuracoes> obj = repository.findById(id); 
		return obj.get();
	}
}
