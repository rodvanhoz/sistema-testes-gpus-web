package com.rvr.sistematestesgpus.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.rvr.sistematestesgpus.entities.tables.Processadores;
import com.rvr.sistematestesgpus.entities.views.Processador;
import com.rvr.sistematestesgpus.repositories.ProcessadoresRepository;
import com.rvr.sistematestesgpus.services.exceptions.DatabaseException;
import com.rvr.sistematestesgpus.services.exceptions.ResourceNotFoundException;

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
	
	public Processadores insert(Processadores obj) {
		return repository.save(obj);
	}
	
	public void delete(Integer id) {
		
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
		catch (DataIntegrityViolationException e1) {
			throw new DatabaseException(e1.getMessage());
		}
		
	}
	
	public Processadores update(Integer id, Processadores obj) {
		try {
			Processadores entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} 
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Processadores entity, Processadores obj) {
		
		entity.setBaseClock(obj.getBaseClock());
		entity.setCodename(obj.getCodename());
		entity.setDadosProcessador(obj.getDadosProcessador());
		entity.setFrequencia(obj.getFrequencia());
		entity.setGeneration(obj.getGeneration());
		entity.setGpu((obj.getGpu() == null) ? null : obj.getGpu());
		entity.setIdProcessador(obj.getIdProcessador());
		entity.setMarket(obj.getMarket());
		entity.setMemorySupport(obj.getMemorySupport());
		entity.setMultiplDesbloqueado(obj.getMultiplDesbloqueado());
		entity.setMultiplicador(obj.getMultiplicador());
		entity.setNomeFabricante(obj.getNomeFabricante());
		entity.setNomeModelo(obj.getNomeModelo());
		entity.setNroCores(obj.getNroCores());
		entity.setNroThreads(obj.getNroThreads());
		entity.setReleased(obj.getReleased());
		entity.setSmp(obj.getSmp());
		entity.setTdp(obj.getTurbofrequencia());
		entity.setTurbofrequencia(obj.getTurbofrequencia());
	}

}
