package com.rvr.sistematestesgpus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rvr.sistematestesgpus.entities.tables.ProcessadorGrafico;
import com.rvr.sistematestesgpus.repositories.ProcessadorGraficoRepository;

@Service
public class ProcessadorGraficoService {

	@Autowired
	private ProcessadorGraficoRepository repository;
	
	public List<ProcessadorGrafico> findAll() {
		return repository.findAll();
	}
	
	public ProcessadorGrafico findById(Integer id) {
		Optional<ProcessadorGrafico> obj = repository.findById(id); 
		return obj.get();
	}
}
