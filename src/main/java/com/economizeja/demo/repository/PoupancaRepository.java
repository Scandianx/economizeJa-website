package com.economizeja.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.economizeja.demo.model.Poupanca;

@Repository
public interface PoupancaRepository extends JpaRepository<Poupanca, Long>{
    
}
