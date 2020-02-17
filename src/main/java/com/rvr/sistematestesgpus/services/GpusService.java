package com.rvr.sistematestesgpus.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rvr.sistematestesgpus.entities.tables.Gpus;
import com.rvr.sistematestesgpus.entities.views.PlacaDeVideo;
import com.rvr.sistematestesgpus.repositories.GpusRepository;

@Service
public class GpusService implements ServiceWithView<Gpus, PlacaDeVideo> {

	@Autowired
	private GpusRepository repository;
	
	@Override
	public List<Gpus> findAll() {
		return repository.findAll();
	}
	
	@Override
	public Gpus findById(Integer id) {
		Optional<Gpus> obj = repository.findById(id); 
		return obj.get();
	}

	@Override
	public List<PlacaDeVideo> findAllView() {
		
		return createListView(findAll());
	}

	@Override
	public PlacaDeVideo findByIdView(Integer id) {
		
		return new PlacaDeVideo(findById(id));
	}
	
	private List<PlacaDeVideo> createListView(List<Gpus> gpuList) {
		
		List<PlacaDeVideo> viewList = new ArrayList<>();
		gpuList.stream()
				.forEach(e ->
					viewList.add(new PlacaDeVideo(e)));
		
		return viewList;
		
		
	}	
}
