package com.tdd.java;

public class Java8StreamsTransaction {
    private final Java8StreamsTrader trader;
    private final int year;
    private final int value;
    public Java8StreamsTransaction(Java8StreamsTrader trader, int year, int value){
        this.trader = trader;
        this.year = year;
        this.value = value;
    }
    public Java8StreamsTrader getTrader(){
        return this.trader;
    }
    public int getYear(){
        return this.year;
    }
    public int getValue(){
        return this.value;
    }
    public String toString(){
        return "{" + this.trader + ", " +
                "year: "+this.year+", " +
                "value:" + this.value +"}";
    }
}
