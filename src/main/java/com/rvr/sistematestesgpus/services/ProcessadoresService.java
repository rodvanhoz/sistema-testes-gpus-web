package com.rvr.sistematestesgpus.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rvr.sistematestesgpus.entities.tables.Processadores;
import com.rvr.sistematestesgpus.entities.views.Processador;
import com.rvr.sistematestesgpus.repositories.ProcessadoresRepository;

@Service
public class ProcessadoresService implements ServiceWithView<Processadores, Processador> {

	@Autowired
	private ProcessadoresRepository repository;
	
	@Override
	public List<Processadores> findAll() {
		return repository.findAll();
	}
	
	@Override
	public Processadores findById(Integer id) {
		Optional<Processadores> obj = repository.findById(id); 
		return obj.get();
	}

	@Override
	public List<Processador> findAllView() {
		return createListView(findAll());
	}

	@Override
	public Processador findByIdView(Integer id) {
		
		return new Processador(findById(id));
	}
	
	private List<Processador> createListView(List<Processadores> processadoresList) {
		
		List<Processador> viewList = new ArrayList<>();
		processadoresList
				.stream()
				.forEach(e ->
					viewList.add(new Processador(e)));
		
		return viewList;
	}	
}
