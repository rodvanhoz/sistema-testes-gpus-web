package com.rvr.sistematestesgpus.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.rvr.sistematestesgpus.entities.tables.CaracteristicasGraficas;
import com.rvr.sistematestesgpus.repositories.CaracteristicasGraficasRepository;
import com.rvr.sistematestesgpus.services.exceptions.DatabaseException;
import com.rvr.sistematestesgpus.services.exceptions.ResourceNotFoundException;

@Service
public class CaracteristicasGraficasService {

	@Autowired
	private CaracteristicasGraficasRepository repository;
	
	public List<CaracteristicasGraficas> findAll() {
		return repository.findAll();
	}
	
	public CaracteristicasGraficas findById(Integer id) {
		Optional<CaracteristicasGraficas> obj = repository.findById(id); 
		return obj.get();
	}
	
	public CaracteristicasGraficas insert(CaracteristicasGraficas obj) {
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
	
	public CaracteristicasGraficas update(Integer id, CaracteristicasGraficas obj) {
		try {
			CaracteristicasGraficas entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} 
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(CaracteristicasGraficas entity, CaracteristicasGraficas obj) {
		
		entity.setCuda(obj.getCuda());
		entity.setDirectX(obj.getDirectX());
		entity.setOpenCL(obj.getOpenCL());
		entity.setOpenGL(obj.getOpenGL());
		entity.setShaderModel(obj.getShaderModel());
		entity.setVulkan(obj.getVulkan());
	}
}
