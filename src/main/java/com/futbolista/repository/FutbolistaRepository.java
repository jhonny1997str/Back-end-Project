package com.futbolista.repository;

import com.futbolista.entity.Futbolista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface FutbolistaRepository extends JpaRepository<Futbolista, Integer> {

    @Query("SELECT f FROM Futbolista f WHERE f.id = :id")
    List<Futbolista> listaPorIdIgual(@Param("id") int id);

    @Query("SELECT e FROM Futbolista e WHERE e.nombres = :nombres AND e.apellidos = :apellidos AND e.id != :id")
    List<Futbolista> actualizaFutbolista(@Param("nombres") String nombres,
                                         @Param("apellidos") String apellidos,
                                         @Param("id") int id);
}


