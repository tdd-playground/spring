package com.tdd.java;

public class Java8StreamsTrader {
    private final String name;
    private final String city;
    public Java8StreamsTrader(String n, String c){
        this.name = n;
        this.city = c;
    }
    public String getName(){
        return this.name;
    }
    public String getCity(){
        return this.city;
    }
    public String toString(){
        return "Trader:"+this.name + " in " + this.city;
    }
}
