package com.rvr.sistematestesgpus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rvr.sistematestesgpus.entities.tables.TestesGpu;
import com.rvr.sistematestesgpus.repositories.TestesGpuRepository;

@Service
public class TestesGpuService {

	@Autowired
	private TestesGpuRepository repository;
	
	public List<TestesGpu> findAll() {
		return repository.findAll();
	}
	
	public TestesGpu findById(Integer id) {
		Optional<TestesGpu> obj = repository.findById(id); 
		return obj.get();
	}
}
