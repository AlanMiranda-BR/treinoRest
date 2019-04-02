package com.fish2048.training.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fish2048.training.domain.IndiceZootecnico;

@Repository	
public interface IndiceZootecnicoRepository extends JpaRepository<IndiceZootecnico, Integer>{

}
