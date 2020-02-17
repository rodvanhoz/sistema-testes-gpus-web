package com.rvr.sistematestesgpus.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.rvr.sistematestesgpus.entities.tables.ConfiguracoesJogos;
import com.rvr.sistematestesgpus.entities.views.ConfiguracoesJogosW;
import com.rvr.sistematestesgpus.repositories.ConfiguracoesJogosRepository;
import com.rvr.sistematestesgpus.services.exceptions.DatabaseException;
import com.rvr.sistematestesgpus.services.exceptions.ResourceNotFoundException;

@Service
public class ConfiguracoesJogosService implements ServiceWithView<ConfiguracoesJogos, ConfiguracoesJogosW> {

	@Autowired
	private ConfiguracoesJogosRepository repository;
	
	@Override
	public List<ConfiguracoesJogos> findAll() {
		return repository.findAll();
	}
	
	@Override
	public ConfiguracoesJogos findById(Integer id) {
		Optional<ConfiguracoesJogos> obj = repository.findById(id); 
		return obj.get();
	}
	
	public ConfiguracoesJogos insert(ConfiguracoesJogos obj) {
		return repository.save(obj);
	}
	
	@Override
	public List<ConfiguracoesJogosW> findAllView() {
		
		return createListView(findAll());
	}
	
	private List<ConfiguracoesJogosW> createListView(List<ConfiguracoesJogos> configuracoesJogosList) {
		
		List<ConfiguracoesJogosW> viewList = new ArrayList<>();
		configuracoesJogosList
				.stream()
				.forEach(e ->
					viewList.add(new ConfiguracoesJogosW(e)));
		
		return viewList;
	}
	
	@Override
	public ConfiguracoesJogosW findByIdView(Integer id) {
		
		return new ConfiguracoesJogosW(findById(id));
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
