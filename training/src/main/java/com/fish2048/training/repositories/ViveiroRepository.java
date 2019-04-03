package com.fish2048.training.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
/**
 * 
 * @author Jhon
 * 
 */
import org.springframework.stereotype.Repository;

import com.fish2048.training.domain.Viveiro;

@Repository
public interface ViveiroRepository extends JpaRepository<Viveiro, Integer>{}
