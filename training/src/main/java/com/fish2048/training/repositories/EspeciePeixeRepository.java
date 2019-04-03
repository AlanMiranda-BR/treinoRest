package com.fish2048.training.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fish2048.training.domain.EspeciePeixe;

/**
 * @author Vitória Ramos
 *
 */
@Repository // acesso ao BD
public interface EspeciePeixeRepository extends JpaRepository<EspeciePeixe, Integer> {
}
