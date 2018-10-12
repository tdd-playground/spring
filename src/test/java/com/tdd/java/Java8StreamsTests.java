package com.tdd.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class Java8StreamsTests {
    @Test
    public void toUpperCase_takesLowerCaseString_returnsAnUpperCaseString() {
        String output = Java8Streams.toUpperCase("abcdef");

        assertThat(output).isEqualTo("ABCDEF");
    }

    @Test
    public void getUpperCaseOnly_passMixedCaseString_returnUppercaseOnlyString() {
        String output = Java8Streams.getUpperCaseOnly("AbCdef");

        assertThat(output).isEqualTo("AC");
    }

    @Test
    public void countOddNumbers_passArrayOfNumbers_returnOddNumbersOnly() {
        long output = Java8Streams.countOddNumbers(1, 2, 3, 4, 5, 6);

        assertThat(output).isEqualTo(3);
    }

    // Linear Search
    // Write a method that returns the index of the first occurrence of given integer in a list.
    // Assume that the index of the first element in the list is zero.
    // If the number does not exist return -1.
    @Test
    public void linearSearch_passListOfIntegers_returnIndexOfFirstFound() {
        int output = Java8Streams.linearSearch(Arrays.asList(4, 2, 5, 9), 9);

        assertThat(output).isEqualTo(3);
    }


    // Reverse String
    // Write a method that reverses a string.
    // For example, 'java interview' becomes 'weivretni avaj'.
    @Test
    public void reverseString_passString_ReturnReversedString() {
        String output = Java8Streams.reverseString("java interview");

        assertThat(output).isEqualTo("weivretni avaj");
    }


    // Find Maximum
    // Write a method that returns the largest integer in the list.
    // You can assume that the list has at least one element.
    @Test
    public void findLargest_passListIntegers_returnLargestInteger() {
        Integer output = Java8Streams.findLargest(Arrays.asList(1, 2, 3, 4, 5, 10, 50, 2, 3, 6, 7));

        assertThat(output).isEqualTo(50);
    }

    @Test(expected = IllegalStateException.class)
    public void findLargest_passEmptyList_throwException() {
        Java8Streams.findLargest(new ArrayList<>());
    }

    @Test
    public void findLargest_passEmptyList_throwExceptionAlt() {
        // Assert for AssertJ
        assertThatThrownBy(() -> Java8Streams.findLargest(new ArrayList<>())).isInstanceOf(IllegalStateException.class);

        // OR
        assertThatIllegalStateException().isThrownBy(() -> Java8Streams.findLargest(new ArrayList<>()));

        // Reverse
        assertThatCode(() -> {
            Java8Streams.findLargest(Arrays.asList(1, 2, 3, 4, 5, 10, 50, 2, 3, 6, 7));
        }).doesNotThrowAnyException();
    }

    // Average Value (Java 8 Lambdas and Streams)
    // Write a method that returns the average of a list of integers.


    // Filter Strings (Java 8 Lambdas and Streams)
    // Given a list of Strings, write a method that returns a list of all strings that start with the letter 'a'
    // (lower case) and have exactly 3 letters.


    // Comma Separated (Java 8 Lambdas and Streams)
    // Write a method that returns a comma separated string based on a given list of integers.
    // Each element should be preceded by the letter 'e' if the number is even,
    // and preceded by the letter 'o' if the number is odd. For example, if the input list is (3,44), the output should be 'o3,e44'.


    // Write a method which returns a sublist of a list of Strings and then returns them as a single string.


    // http://code-exercises.com/programming/medium/22/comma-separated-java-8-lambdas-and-streams


    // Given a list of numbers, how would you return a list of the square of each number? For example, given [1, 2, 3, 4, 5] you should return [1, 4, 9, 16, 25].
    @Test
    public void squareNumbers_passListOfNumbers_returnListSquareOfNumbers() {
        List<Integer> output = Java8Streams.squareNumbers(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));
        assertThat(output).isEqualTo(new ArrayList<>(Arrays.asList(1, 4, 9, 16, 25)));
    }

    // Given two lists of numbers, how would you return all pairs of numbers? For example, given a list [1, 2, 3] and a list [3, 4] you should return [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]. For simplicity, you can represent a pair as an array with two elements.
    @Test
    public void pairNumbers_passTwoListsNumbers_returnListOfPairs() {
        List<int[]> output = Java8Streams.pairNumbers(new ArrayList<>(Arrays.asList(1, 2, 3)), new ArrayList<>(Arrays.asList(3, 4)));
        assertThat(output).containsExactly(new int[]{1, 3}, new int[]{1, 4}, new int[]{2, 3}, new int[]{2, 4}, new int[]{3, 3}, new int[]{3, 4});
    }

    // How would you extend the previous example to return only pairs whose sum is divisible by 3? For example, (2, 4) and (3, 3) are valid.
    @Test
    public void pairNumbersDivisibleBy3_passTwoListsNumbers_returnListsOfPairs() {
        List<int[]> output = Java8Streams.pairNumbersDivisibleBy3(new ArrayList<>(Arrays.asList(1, 2, 3)), new ArrayList<>(Arrays.asList(3, 4)));
        assertThat(output).containsExactly(new int[]{2, 4}, new int[]{3, 3});
    }
}
