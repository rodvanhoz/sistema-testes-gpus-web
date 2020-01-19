package com.rvr.sistematestesgpus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rvr.sistematestesgpus.entities.tables.DadosProcessador;
import com.rvr.sistematestesgpus.repositories.DadosProcessadorRepository;

@Service
public class DadosProcessadorService {

	@Autowired
	private DadosProcessadorRepository repository;
	
	public List<DadosProcessador> findAll() {
		return repository.findAll();
	}
	
	public DadosProcessador findById(Integer id) {
		Optional<DadosProcessador> obj = repository.findById(id); 
		return obj.get();
	}
}
