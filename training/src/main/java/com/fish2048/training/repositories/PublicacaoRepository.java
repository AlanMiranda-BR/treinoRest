package com.fish2048.training.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fish2048.training.domain.Publicacao;

/**
 * @author Wellinton Camboim
 *
 */
@Repository
public interface PublicacaoRepository extends JpaRepository<Publicacao, Integer>{}
