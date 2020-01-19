package com.rvr.sistematestesgpus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rvr.sistematestesgpus.entities.tables.Jogos;
import com.rvr.sistematestesgpus.repositories.JogosRepository;

@Service
public class JogosService {

	@Autowired
	private JogosRepository repository;
	
	public List<Jogos> findAll() {
		return repository.findAll();
	}
	
	public Jogos findById(Integer id) {
		Optional<Jogos> obj = repository.findById(id); 
		return obj.get();
	}
}
