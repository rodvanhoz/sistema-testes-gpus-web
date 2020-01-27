package com.rvr.sistematestesgpus.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.rvr.sistematestesgpus.entities.tables.ConfiguracoesJogos;
import com.rvr.sistematestesgpus.repositories.ConfiguracoesJogosRepository;
import com.rvr.sistematestesgpus.services.exceptions.DatabaseException;
import com.rvr.sistematestesgpus.services.exceptions.ResourceNotFoundException;

@Service
public class ConfiguracoesJogosService {

	@Autowired
	private ConfiguracoesJogosRepository repository;
	
	public List<ConfiguracoesJogos> findAll() {
		return repository.findAll();
	}
	
	public ConfiguracoesJogos findById(Integer id) {
		Optional<ConfiguracoesJogos> obj = repository.findById(id); 
		return obj.get();
	}
	
	public ConfiguracoesJogos insert(ConfiguracoesJogos obj) {
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
	
	public ConfiguracoesJogos update(Integer id, ConfiguracoesJogos obj) {
		try {
			ConfiguracoesJogos entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} 
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(ConfiguracoesJogos entity, ConfiguracoesJogos obj) {
		
		entity.setConfiguracao(obj.getConfiguracao());
		entity.setJogo(obj.getJogo());
	}
}
