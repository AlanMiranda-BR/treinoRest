package com.fish2048.training.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fish2048.training.domain.LotePeixe;

/**
 * @author Vitória Ramos
 *
 */
@Repository
public interface LotePeixeRepository extends JpaRepository<LotePeixe, Integer> {}
