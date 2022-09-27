package com.supermercado.service;

import java.util.List;
import java.util.Optional;

import com.supermercado.model.Item;

public interface IItemService {

	Optional<Item> findById(Integer id);

	List<Item> findAll();
	
	Item save(Item item);
	
	void delete(Item item);

}
