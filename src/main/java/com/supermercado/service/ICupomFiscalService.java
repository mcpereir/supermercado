package com.supermercado.service;

import java.util.List;
import java.util.Optional;

import com.supermercado.model.CupomFiscal;

public interface ICupomFiscalService {

	Optional<CupomFiscal> findById(Integer id);

	List<CupomFiscal> findAll();
	
	CupomFiscal save(CupomFiscal cupomFiscal);
	
	void delete(CupomFiscal cupomFiscal);

}
