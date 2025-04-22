package com.example.demo.repository;

import com.example.demo.model.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEntrenadorRepository extends JpaRepository<Entrenador, Long>  {
}
