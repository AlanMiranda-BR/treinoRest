package com.fish2048.training.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fish2048.training.domain.Manejo;

/**
 * @author Gabriel Mauro
 *
 */
@Repository
public interface ManejoRepository extends JpaRepository<Manejo, Integer> {
	
	@Query("SELECT DISTINCT obj FROM Manejo obj WHERE id.povoamento.id = ?1")
	List<Manejo> findByIdCompoused(Integer id); //Busca customizada, para usar com a chave composta.
	
}
