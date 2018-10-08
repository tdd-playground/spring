package com.tdd.spring.simplemockexample;

public class SimpleMock {

    private SomeDependency someDependency = new SomeDependencyImpl();
    private SomeClassToSpyOn someClassToSpyOn = new SomeClassToSpyOnImpl();

    public void callSomethingWithDependency() {
        someDependency.doSomething();
        someClassToSpyOn.setValue(10);
        someClassToSpyOn.getValue();
    }

    public void callSomethingWithDependencyWithParameter() {
        someDependency.doSomethingElse("Hello");
        someDependency.doSomethingElse("Again");
        someClassToSpyOn.setValue(10);
        int theValueSetBySpy = someClassToSpyOn.getValue();
        System.out.println(theValueSetBySpy);
    }
}
