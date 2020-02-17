package com.rvr.sistematestesgpus.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.rvr.sistematestesgpus.entities.tables.Gpus;
import com.rvr.sistematestesgpus.entities.views.PlacaDeVideo;
import com.rvr.sistematestesgpus.repositories.GpusRepository;
import com.rvr.sistematestesgpus.services.exceptions.DatabaseException;
import com.rvr.sistematestesgpus.services.exceptions.ResourceNotFoundException;

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
	
	public Gpus insert(Gpus obj) {
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
	
	public Gpus update(Integer id, Gpus obj) {
		try {
			Gpus entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} 
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Gpus entity, Gpus obj) {
		
		entity.setBoostClock(obj.getBoostClock());
		entity.setBusInterface(obj.getBusInterface());
		entity.setCaracteristicasGraficas(obj.getCaracteristicasGraficas());
		entity.setDtLancto(obj.getDtLancto());
		entity.setGpuClock(obj.getGpuClock());
		entity.setIdGpu(obj.getIdGpu());
		entity.setMemClock(obj.getMemClock());
		entity.setMemClockEfetivo(obj.getMemClockEfetivo());
		entity.setNomeFabricante(obj.getNomeFabricante());
		entity.setNomeModelo(obj.getNomeModelo());
		entity.setProcessadorGrafico(obj.getProcessadorGrafico());
		entity.setRenderConfig(obj.getRenderConfig());
		entity.setTamBanda(obj.getTamBanda());
		entity.setTamMemoriaKB(obj.getTamMemoriaKB());
		entity.setTdp(obj.getTdp());
		entity.setTpMemoria(obj.getTpMemoria());
	}


}
