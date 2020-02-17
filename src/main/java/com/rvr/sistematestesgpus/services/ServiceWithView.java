package com.rvr.sistematestesgpus.services;

import java.util.List;

public interface ServiceWithView<T, F> {
	
	public List<T> findAll();
	
	public T findById(Integer i);
	
	public List<F> findAllView();
	
	public F findByIdView(Integer id);
	
}
