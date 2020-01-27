package com.rvr.sistematestesgpus.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.rvr.sistematestesgpus.entities.tables.Jogos;
import com.rvr.sistematestesgpus.repositories.JogosRepository;
import com.rvr.sistematestesgpus.services.exceptions.DatabaseException;
import com.rvr.sistematestesgpus.services.exceptions.ResourceNotFoundException;

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
	
	public Jogos insert(Jogos obj) {
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
	
	public Jogos update(Integer id, Jogos obj) {
		try {
			Jogos entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} 
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Jogos entity, Jogos obj) {
		
		entity.setNomeJogo(obj.getNomeJogo());
		entity.setDtLancto(obj.getDtLancto());;
	}
}
