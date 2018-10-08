package com.tdd.spring.simplemockexample;

public class SomeDependencyImpl implements SomeDependency {

    @Override
    public int doSomething() {
        return 0;
    }

    @Override
    public int doSomethingElse(String string) {
        return 0;
    }
}
