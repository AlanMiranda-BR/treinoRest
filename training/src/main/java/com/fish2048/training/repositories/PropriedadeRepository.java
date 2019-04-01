package com.fish2048.training.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fish2048.training.domain.Propriedade;
//faz o acesso ao banco de dados, trabalha com o Java hibernate e o banco de dados
@Repository
public interface PropriedadeRepository extends JpaRepository<Propriedade, Integer>{

}
