package com.fish2048.training.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fish2048.training.domain.Ph;

public interface PhRepository extends JpaRepository<Ph, Integer> {

}
