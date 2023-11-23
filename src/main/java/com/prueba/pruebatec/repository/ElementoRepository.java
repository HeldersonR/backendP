package com.prueba.pruebatec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.pruebatec.entity.Elemento;
@Repository

public interface ElementoRepository extends JpaRepository<Elemento,Integer>{
    Optional<Elemento> findByCategoria(String categoria);
    boolean existsByCategoria(String categoria);
   
    Optional<Elemento> findByTitulo(String titulo);
    boolean existsByTitulo(String titulo);
    Optional<Elemento> findByDescripcion(String descripcion);

 }
    

