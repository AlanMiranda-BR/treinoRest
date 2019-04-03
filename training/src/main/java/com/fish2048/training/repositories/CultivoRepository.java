package com.fish2048.training.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fish2048.training.domain.Cultivo;

/**
 * @author Alan Felipe Miranda
 *
 */
@Repository
public interface CultivoRepository extends JpaRepository<Cultivo, Integer>{}
