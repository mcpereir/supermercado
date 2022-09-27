package com.supermercado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermercado.model.CupomFiscal;
import com.supermercado.repository.CupomFiscalRepository;


@Service()
public class ImplCupomFiscalService implements ICupomFiscalService {

	
	@Autowired
	private CupomFiscalRepository cupomFiscalRepository;
	 
	@Override
	public Optional<CupomFiscal> findById(Integer id) {
		return cupomFiscalRepository.findById(id);
	}

	@Override
	public List<CupomFiscal> findAll() {
		return cupomFiscalRepository.findAll();
	}
	
	@Override
    public CupomFiscal save(CupomFiscal cupomFiscal) {
        return cupomFiscalRepository.save(cupomFiscal);
    }

	@Override
	public void delete(CupomFiscal cupomFiscal) {
		cupomFiscalRepository.delete(cupomFiscal);
	}
    
}
