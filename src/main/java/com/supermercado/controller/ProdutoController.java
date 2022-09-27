package com.supermercado.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.supermercado.model.Produto;
import com.supermercado.repository.ProdutoRepository;


@RestController
@RequestMapping(value="/supermercado")
public class ProdutoController {

	@Autowired
	private ProdutoRepository pr;
	
	
	@GetMapping(value="/tproduto")
	public String getTestes(){
		return  "API";
	}
	
	@GetMapping(value="/produtos")
	public List<Produto> getAllCupons(){
		
		return  pr.findAll();
		
	}
	
	@GetMapping(value = "/produto/{id}")
	public Object getCupomFiscalById(@PathVariable("id") Integer id ) {

		try {
			
			return pr.findById(id).get();
			
		} catch (RuntimeException exc) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto Não Existe !", exc);
		}

	}
	


	@RequestMapping(value = "/produto1/{id}", method = RequestMethod.POST)
	public ResponseEntity<Produto> updateProduto(@PathVariable(value = "id") Integer produtoId, @Validated @RequestBody Produto newProduto) {
	    
		Optional<Produto> oldProduto = pr.findById(produtoId);
		
		if(oldProduto.isPresent()) {
			Produto prod = oldProduto.get();
			prod.setDescricao(newProduto.getDescricao());
			pr.save(prod);
			return new ResponseEntity<Produto>(prod, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
