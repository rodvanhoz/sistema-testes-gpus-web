package com.rvr.sistematestesgpus.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rvr.sistematestesgpus.entities.tables.TestesGpu;
import com.rvr.sistematestesgpus.entities.views.DadosTeste;
import com.rvr.sistematestesgpus.repositories.TestesGpuRepository;

@Service
public class TestesGpuService implements ServiceWithView<TestesGpu, DadosTeste> {

	@Autowired
	private TestesGpuRepository repository;
	
	@Override
	public List<TestesGpu> findAll() {
		return repository.findAll();
	}
	
	@Override
	public TestesGpu findById(Integer id) {
		Optional<TestesGpu> obj = repository.findById(id); 
		return obj.get();
	}
	
	@Override
	public List<DadosTeste> findAllView() {
		
		return createListView(findAll());
	}
	
	private List<DadosTeste> createListView(List<TestesGpu> testeGpuList) {
		
		List<DadosTeste> viewList = new ArrayList<>();
		testeGpuList
				.stream()
				.forEach(e ->
					viewList.add(new DadosTeste(e)));
		
		return viewList;
		
		
	}	
	
	public DadosTeste findByIdView(Integer id) {
	
		return new DadosTeste(findById(id));
	}
}
