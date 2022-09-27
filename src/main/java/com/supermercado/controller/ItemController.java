package com.supermercado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.supermercado.model.Item;
import com.supermercado.repository.ItemRepository;


@RestController
@RequestMapping(value="/supermercado", produces={MediaType.APPLICATION_JSON_VALUE})
public class ItemController {

	@Autowired
	private ItemRepository ir;
	
	@GetMapping(value="/itens")
	public List<Item> getAllCupons(){
		
		return  ir.findAll();
		
	}
	
	@GetMapping(value = "/item/{id}")
	public Object getCupomFiscalById(@PathVariable("id") Integer id ) {

		try {
			
			return ir.findById(id).get();
			
		} catch (RuntimeException exc) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item Não Existe !", exc);
		}

	}
	
}
