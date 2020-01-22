package com.rvr.sistematestesgpus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rvr.sistematestesgpus.entities.tables.Gpus;

public interface GpusRepository extends JpaRepository<Gpus, Integer> {

}
