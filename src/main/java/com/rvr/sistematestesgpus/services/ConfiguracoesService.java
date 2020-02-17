package com.rvr.sistematestesgpus.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.rvr.sistematestesgpus.entities.tables.Configuracoes;
import com.rvr.sistematestesgpus.repositories.ConfiguracoesRepository;
import com.rvr.sistematestesgpus.services.exceptions.DatabaseException;
import com.rvr.sistematestesgpus.services.exceptions.ResourceNotFoundException;

@Service
public class ConfiguracoesService {

	@Autowired
	private ConfiguracoesRepository repository;
	
	public List<Configuracoes> findAll() {
		return repository.findAll();
	}
	
	public Configuracoes findById(Integer id) {
		Optional<Configuracoes> obj = repository.findById(id); 
		return obj.get();
	}
	
	public Configuracoes insert(Configuracoes obj) {
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
	
	public Configuracoes update(Integer id, Configuracoes obj) {
		try {
			Configuracoes entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} 
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Configuracoes entity, Configuracoes obj) {
		
		entity.setAa(obj.getAa());
		entity.setApi(obj.getApi());
		entity.setFxaa(obj.getFxaa());
		entity.setIdConfiguracao(obj.getIdConfiguracao());
		entity.setNVidiaTec(obj.getNVidiaTec());
		entity.setQualidadeGrafica(obj.getQualidadeGrafica());
		entity.setResolucaoAbrev(obj.getResolucaoAbrev());
		entity.setResolucaoDetalhe(obj.getResolucaoDetalhe());
		entity.setRt(obj.getRt());
		entity.setSsao(obj.getSsao());
		entity.setTaa(obj.getTaa());
	}


}
