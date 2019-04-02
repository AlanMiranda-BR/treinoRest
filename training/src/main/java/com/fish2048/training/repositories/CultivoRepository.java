package com.fish2048.training.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fish2048.training.domain.Cultivo;

@Repository
public interface CultivoRepository extends JpaRepository<Cultivo, Integer>{
}
