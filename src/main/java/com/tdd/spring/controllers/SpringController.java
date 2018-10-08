package com.tdd.spring.controllers;

import com.tdd.spring.domain.Item;
import com.tdd.spring.services.ItemBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/items")
    public List<Item> getAllItemsFromRepository(){
        return itemBusinessService.getItemsFromRepository();
    }

    @PostMapping(path = "/item-update", consumes = "application/json")
    public void samplePostService(@RequestBody Item aBody){
        System.out.println(aBody);
    }
}
