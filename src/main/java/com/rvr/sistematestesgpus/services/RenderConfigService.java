package com.rvr.sistematestesgpus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rvr.sistematestesgpus.entities.tables.RenderConfig;
import com.rvr.sistematestesgpus.repositories.RenderConfigRepository;

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
}
