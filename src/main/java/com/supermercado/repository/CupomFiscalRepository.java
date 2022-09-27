package com.supermercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.supermercado.model.CupomFiscal;

@Repository
public interface CupomFiscalRepository extends JpaRepository<CupomFiscal, Integer>{

}
