package com.tdd.demo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Item {

    @Id
    private int id;
    private String name;

    @Transient // Don't add to database
    private int value;

    // JPA provider has to instantiate your domain object dynamically.
    // It cannot do so, unless there is a no-arg constructor
    protected Item(){} // default constructor required by JPA provider

    public Item(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
