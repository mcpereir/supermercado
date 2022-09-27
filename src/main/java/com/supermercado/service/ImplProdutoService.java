package com.supermercado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermercado.model.Produto;
import com.supermercado.repository.ProdutoRepository;


@Service()
public class ImplProdutoService implements IProdutoService {

	
	@Autowired
	private ProdutoRepository produtoRepository;
	 
	@Override
	public Optional<Produto> findById(Integer id) {
		return produtoRepository.findById(id);
	}

	@Override
	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}
	
	@Override
    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

	@Override
	public void delete(Produto produto) {
		produtoRepository.delete(produto);
	}
    
}
