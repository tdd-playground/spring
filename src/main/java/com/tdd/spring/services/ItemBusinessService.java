package com.tdd.spring.services;

import com.tdd.spring.domain.Item;

import java.util.List;

public interface ItemBusinessService {

    Item getItem();
    List<Item> getItemsFromRepository();
}
