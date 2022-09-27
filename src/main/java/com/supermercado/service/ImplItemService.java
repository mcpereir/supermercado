package com.supermercado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermercado.model.Item;
import com.supermercado.repository.ItemRepository;


@Service()
public class ImplItemService implements IItemService {

	
	@Autowired
	private ItemRepository itemRepository;
	 
	@Override
	public Optional<Item> findById(Integer id) {
		return itemRepository.findById(id);
	}

	@Override
	public List<Item> findAll() {
		return itemRepository.findAll();
	}
	
	@Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

	@Override
	public void delete(Item item) {
		itemRepository.delete(item);
	}
    
}
