package com.tdd.demo.simplemockexample;

public class SomeClassToSpyOnImpl implements SomeClassToSpyOn {

    private int aValueToSee = 0;

    @Override
    public int getValue() {
        return aValueToSee;
    }

    public void setValue(int aValue){
        this.aValueToSee = aValue;
    }
}
