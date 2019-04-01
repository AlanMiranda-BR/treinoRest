package com.fish2048.training.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fish2048.training.domain.Povoamento;

/**
 * @author Alan Felipe Miranda
 * Interface reponsavel por realizar a comunicação com o hibernate e consequentemente com o Banco de Dados.
 * Habilitado somente a busca por IDs <Povoamento, Integer>
 */
@Repository
public interface PovoamentoRepository extends JpaRepository<Povoamento, Integer>{}
