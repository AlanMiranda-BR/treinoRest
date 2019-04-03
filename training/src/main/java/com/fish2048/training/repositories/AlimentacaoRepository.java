package com.fish2048.training.repositories;

/**
 * @author Rafael Silva Neukirchen
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fish2048.training.domain.Alimentacao;

@Repository
public interface AlimentacaoRepository extends JpaRepository<Alimentacao, Integer> {}
