package com.rvr.sistematestesgpus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rvr.sistematestesgpus.entities.tables.Gpus;
import com.rvr.sistematestesgpus.repositories.GpusRepository;

@Service
public class GpusService {

	@Autowired
	private GpusRepository repository;
	
	public List<Gpus> findAll() {
		return repository.findAll();
	}
	
	public Gpus findById(Integer id) {
		Optional<Gpus> obj = repository.findById(id); 
		return obj.get();
	}
}
