package com.tdd.demo.services;

import com.tdd.demo.domain.Item;

import java.util.List;

public interface ItemBusinessService {

    Item getItem();
    List<Item> getItemsFromRepository();
}
