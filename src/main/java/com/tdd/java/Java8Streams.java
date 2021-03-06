package com.tdd.java;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Java8Streams {

    public static String toUpperCase(String input) {
        return input.chars()
                .map(Character::toUpperCase)
                .mapToObj(c -> Character.toString((char) c))
                .collect(Collectors.joining());
    }

    public static String getUpperCaseOnly(String input) {
        return input.chars()
                .filter(Character::isUpperCase)
                .mapToObj(c -> Character.toString((char) c)) // Convert to String
                .collect(Collectors.joining());
    }

    public static long countOddNumbers(int... input) {
        IntStream.of(input)
                .filter(i -> (i % 2) != 0)
                .peek(System.out::println);
        // The above won't print anything since peek is not a terminal operation
        // count(), forEach(), collect() are terminal operations.
        // Without a terminal operation the stream will not execute, though argument checks are always performed.
        // So the Predicate passed to filter will be checked for validity (not null)

        return IntStream.of(input)
                .filter(i -> (i % 2) != 0)
                .peek(System.out::println) // This works because of count.
                .count();
    }

    public static int linearSearch(List<Integer> asList, int i) {

        OptionalInt optionalInt = //asList.stream()
                IntStream.range(0, asList.size())
                        //.flatMapToInt(num -> IntStream.of(Integer.valueOf(num)))
                        .filter(index -> i == asList.get(index))
                        .findFirst();
        return optionalInt.orElse(-1);
    }

    public static String reverseString(String input) {
        StringBuilder sb = new StringBuilder();
        input.chars()
                .forEach(c -> sb.insert(0, (char) c));
        return sb.toString();
    }

    public static Integer findLargest(List<Integer> integerList) {
        return integerList.stream().max(Integer::compareTo).orElseThrow(IllegalStateException::new);
    }

    public static int findSumOfDivisers(int number) {
        return IntStream.range(0, number)
                .filter(n -> (n % 3 == 0) || (n % 5 == 0))
                .sum();
    }

    public static List<Integer> squareNumbers(ArrayList<Integer> integers) {
        return integers.stream()
                .map(x -> x * x)
                .collect(toList());
    }

    public static List<int[]> pairNumbers(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        return list1.stream()
                .flatMap(i -> list2.stream()
                        .map(j -> new int[]{i, j})
                )
                .collect(toList());
    }

    public static List<int[]> pairNumbersDivisibleBy3(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        return list1.stream()
                .flatMap(i -> list2.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j})
                )
                .collect(toList());
    }
}
