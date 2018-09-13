package com.tdd.demo.simplemockexample;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SimpleMockTests {
    @Mock // Will create a mock implementation of the dependency
    SomeDependency someDependency; // You can create a mock against the interface

    @Spy
    SomeClassToSpyOnImpl someClassToSpyOn; // Note that spies should be used on the implementation, not the interface

    @InjectMocks // Will inject the mocks marked with @Mock to this instance when it is created.
    private SimpleMock simpleMock;

    @Before
    public void setUp() {
        // So these instances would be created at the start of every test method of this test class.
        MockitoAnnotations.initMocks(this);
        // To reset a spy for each test, use spyTestObject = spy(testObject);
    }

    @Test
    public void someDependencyTest() {
        when(someDependency.doSomething()).thenReturn(1); // The when then pattern thenReturn(returnValue), thenThrow(exception), thenCallRealMethod(), thenAnswer()
        simpleMock.callSomethingWithDependency();
        verify(someDependency, times(1)).doSomething();
        verify(someDependency, atLeastOnce()).doSomething();
        verify(someDependency, atLeast(1)).doSomething();
    }

    // Using matchers --> when(dao.save(any(Customer.class))).thenReturn(true);

    // Verifying void methods - when you cannot verify the return, so you have to verify on the mock:
    // times(int wantedNumberOfInvocations)
    // atLeast(int wantedNumberOfInvocations)
    // atMost(int wantedNumberOfInvocations)
    // calls(int wantedNumberOfInvocations)
    // only(int wantedNumberOfInvocations)
    // atLeastOnce()
    // never()

    // Spy --> Sometimes we need to call real methods of a dependency but still want to verify or track interactions with that dependency.

    // Argument Capturing
    @Test
    public void someArgumentCaptureTest() {
        simpleMock.callSomethingWithDependencyWithParameter();

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        verify(someDependency, times(2)).doSomethingElse(captor.capture());
        assertEquals("Again", captor.getValue()); // Captures the last call parameter value
    }

    @Test
    public void someArgumentCaptureWhenCalledMultipleTimesTest() {
        simpleMock.callSomethingWithDependencyWithParameter();

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        verify(someDependency, times(2)).doSomethingElse(captor.capture());
        assertEquals("Hello", captor.getAllValues().get(0));
        assertEquals("Again", captor.getAllValues().get(1));
    }

    // Spies - spies use the real class instead of a mock - original behavior of class is retained -  to spy on a real object.
    // When to use - when you want to find out what is happening with original dependency.
    @Test
    public void someSpyTest() {
        simpleMock.callSomethingWithDependency();
        assertEquals(10, someClassToSpyOn.getValue());

        when(someClassToSpyOn.getValue()).thenReturn(6);
        simpleMock.callSomethingWithDependencyWithParameter();
        verify(someClassToSpyOn, times(3)).getValue();
        assertEquals(6, someClassToSpyOn.getValue());
    }

    // Difference in Mock and Spy:
    // When Mockito creates a mock – it does so from the Class of an Type, not from an actual instance.
    // The mock simply creates a bare-bones shell instance of the Class, entirely instrumented to track interactions with it.

    // On the other hand, the spy will wrap an existing instance.
    // It will still behave in the same way as the normal instance –
    // the only difference is that it will also be instrumented to track all the interactions with it.
}
