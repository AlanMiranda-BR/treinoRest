package com.fish2048.training.repositories;
//reup
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fish2048.training.domain.EspeciePeixe;

@Repository //acesso ao BD
public interface EspeciePeixeRepository extends JpaRepository<EspeciePeixe, Integer>{

}
