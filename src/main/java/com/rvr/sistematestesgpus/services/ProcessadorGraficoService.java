package com.rvr.sistematestesgpus.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.rvr.sistematestesgpus.entities.tables.ProcessadorGrafico;
import com.rvr.sistematestesgpus.repositories.ProcessadorGraficoRepository;
import com.rvr.sistematestesgpus.services.exceptions.DatabaseException;
import com.rvr.sistematestesgpus.services.exceptions.ResourceNotFoundException;

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
	
	public ProcessadorGrafico insert(ProcessadorGrafico obj) {
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
	
	public ProcessadorGrafico update(Integer id, ProcessadorGrafico obj) {
		try {
			ProcessadorGrafico entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} 
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(ProcessadorGrafico entity, ProcessadorGrafico obj) {
		
		entity.setArquitetura(obj.getArquitetura());
		entity.setFundicao(obj.getFundicao());
		entity.setMmProcessador(obj.getMmProcessador());
		entity.setNnProcessador(obj.getNnProcessador());
		entity.setNomeGpu(obj.getNomeGpu());
		entity.setNroTransistors(obj.getNroTransistors());
		entity.setVariantGpu(obj.getVariantGpu());
	}
}
