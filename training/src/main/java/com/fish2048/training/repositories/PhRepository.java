package com.fish2048.training.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fish2048.training.domain.Ph;

/**
 * @author Gabriel Mauro
 *
 */
public interface PhRepository extends JpaRepository<Ph, Integer> {}
