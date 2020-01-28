package com.rvr.sistematestesgpus.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.rvr.sistematestesgpus.entities.tables.RenderConfig;
import com.rvr.sistematestesgpus.repositories.RenderConfigRepository;
import com.rvr.sistematestesgpus.services.exceptions.DatabaseException;
import com.rvr.sistematestesgpus.services.exceptions.ResourceNotFoundException;

@Service
public class RenderConfigService {

	@Autowired
	private RenderConfigRepository repository;
	
	public List<RenderConfig> findAll() {
		return repository.findAll();
	}
	
	public RenderConfig findById(Integer id) {
		Optional<RenderConfig> obj = repository.findById(id); 
		return obj.get();
	}
	
	public RenderConfig insert(RenderConfig obj) {
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
	
	public RenderConfig update(Integer id, RenderConfig obj) {
		try {
			RenderConfig entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} 
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(RenderConfig entity, RenderConfig obj) {
		
		entity.setL1Cache(obj.getL1Cache());
		entity.setL2Cache(obj.getL2Cache());
		entity.setRops(obj.getRops());
		entity.setRtCores(obj.getRtCores());
		entity.setShadingUnits(obj.getShadingUnits());
		entity.setSmCount(obj.getSmCount());
		entity.setTensorCores(obj.getTensorCores());
		entity.setTmus(obj.getTmus());
	}
}
