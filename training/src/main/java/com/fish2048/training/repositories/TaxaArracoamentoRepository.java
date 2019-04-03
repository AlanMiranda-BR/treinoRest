package com.fish2048.training.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fish2048.training.domain.TaxaArracoamento;

/**
 * @author Wellinton Camboim
 *
 */
@Repository
public interface TaxaArracoamentoRepository extends JpaRepository<TaxaArracoamento, Integer> {

}
