package com.tdd.demo.controllers;

import com.tdd.demo.domain.Item;
import com.tdd.demo.services.ItemBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/foo")
public class SpringController {

    @Autowired
    ItemBusinessService itemBusinessService;

    @GetMapping("/bar") // A shortcut for @RequestMapping(method = RequestMethod.GET)
    public String getHelloWorld(){
        return "Hello World!";
    }

    @GetMapping("/item")
    public Item getItem(){
        return new Item(123, "An Item");
    }

    @GetMapping("/item-service")
    public Item getItemFromBusinessService(){
        return itemBusinessService.getItem();
    }
}
