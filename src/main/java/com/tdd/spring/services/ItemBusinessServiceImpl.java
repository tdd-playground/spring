package com.tdd.spring.services;

import com.tdd.spring.domain.Item;
import com.tdd.spring.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemBusinessServiceImpl implements ItemBusinessService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public Item getItem() {
        return new Item(123, "An Item");
    }

    @Override
    public List<Item> getItemsFromRepository() {
        return itemRepository.findAll();
    }
}
