package com.supermercado.service;

import java.util.List;
import java.util.Optional;

import com.supermercado.model.Produto;

public interface IProdutoService {

	Optional<Produto> findById(Integer id);

	List<Produto> findAll();
	
	Produto save(Produto produto);
	
	void delete(Produto produto);

}
