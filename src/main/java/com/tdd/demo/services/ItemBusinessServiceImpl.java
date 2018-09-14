package com.tdd.demo.services;

import com.tdd.demo.domain.Item;
import org.springframework.stereotype.Service;

@Service
public class ItemBusinessServiceImpl implements ItemBusinessService {

    @Override
    public Item getItem() {
        return new Item(123, "An Item");
    }
}
