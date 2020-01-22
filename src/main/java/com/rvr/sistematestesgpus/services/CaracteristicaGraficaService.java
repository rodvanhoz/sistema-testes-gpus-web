package com.rvr.sistematestesgpus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rvr.sistematestesgpus.entities.tables.CaracteristicasGraficas;
import com.rvr.sistematestesgpus.repositories.CaracteristicasGraficasRepository;

@Service
public class CaracteristicaGraficaService {

	@Autowired
	private CaracteristicasGraficasRepository repository;
	
	public List<CaracteristicasGraficas> findAll() {
		return repository.findAll();
	}
	
	public CaracteristicasGraficas findById(Integer id) {
		Optional<CaracteristicasGraficas> obj = repository.findById(id); 
		return obj.get();
	}
}
