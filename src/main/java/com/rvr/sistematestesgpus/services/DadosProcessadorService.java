package com.rvr.sistematestesgpus.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.rvr.sistematestesgpus.entities.tables.DadosProcessador;
import com.rvr.sistematestesgpus.repositories.DadosProcessadorRepository;
import com.rvr.sistematestesgpus.services.exceptions.DatabaseException;
import com.rvr.sistematestesgpus.services.exceptions.ResourceNotFoundException;

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
	
	public DadosProcessador insert(DadosProcessador obj) {
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
	
	public DadosProcessador update(Integer id, DadosProcessador obj) {
		try {
			DadosProcessador entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} 
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(DadosProcessador entity, DadosProcessador obj) {
		
		entity.setFoundry(obj.getFoundry());
		entity.setPackag(obj.getPackag());
		entity.setProcessSize(obj.getProcessSize());
		entity.setSocket(obj.getSocket());
		entity.settCaseMax(obj.gettCaseMax());
		entity.setTransistors(obj.getTransistors());
	}
		
}
