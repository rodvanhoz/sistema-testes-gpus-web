package com.rvr.sistematestesgpus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rvr.sistematestesgpus.entities.tables.Processadores;
import com.rvr.sistematestesgpus.repositories.ProcessadoresRepository;

@Service
public class ProcessadoresService {

	@Autowired
	private ProcessadoresRepository repository;
	
	public List<Processadores> findAll() {
		return repository.findAll();
	}
	
	public Processadores findById(Integer id) {
		Optional<Processadores> obj = repository.findById(id); 
		return obj.get();
	}
}
