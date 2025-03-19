package com.futbolista.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolista.entity.Posicion;

public interface PosicionRepository extends JpaRepository<Posicion, Integer> {

	
}
