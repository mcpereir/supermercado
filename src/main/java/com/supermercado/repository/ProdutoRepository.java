package com.supermercado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supermercado.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
	
	public Produto findByDescricao(String descricao);
	public List<Produto> findByDescricaoContaining(String descricao);
	public Produto findByCodigo(Integer cod);

}
