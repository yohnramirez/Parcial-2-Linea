package com.example.demo.repository;

import com.example.demo.model.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEquipoRepository extends JpaRepository<Equipo, Long> {
}
