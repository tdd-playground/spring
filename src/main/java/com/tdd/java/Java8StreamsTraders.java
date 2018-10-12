package com.tdd.java;

import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Java8StreamsTraders {
    public static List<Java8StreamsTransaction> findTransactionsByYear(List<Java8StreamsTransaction> transactions) {
        return transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(comparing(Java8StreamsTransaction::getValue).reversed())
                .collect(toList());
    }

    public static List<String> findUniqueCities(List<Java8StreamsTransaction> transactions) {
        return transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(toList());
    }

    public static List<String> findTradersByCity(List<Java8StreamsTransaction> transactions) {
        return transactions.stream()
                .filter(t -> t.getTrader().getCity() == "Cambridge")
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .collect(toList());
    }

    public static String returnNamesAsDelimitiedString(List<Java8StreamsTransaction> transactions) {
        return transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .collect(joining(", "));
    }

    public static boolean isBasedInCity(List<Java8StreamsTransaction> transactions, String city) {
        return transactions.stream()
                .filter(t -> t.getTrader().getCity().equals(city))
                .distinct()
                .count() > 0;

        // Should have used anyMatch
        // boolean milanBased =
        //    transactions.stream()
        //                .anyMatch(transaction -> transaction.getTrader()
        //                                                    .getCity()
        //                                                    .equals("Milan"));
    }

    public static void printValuesFromTradersInGivenCity(List<Java8StreamsTransaction> transactions, String city) {
        System.out.println(
                transactions.stream()
                    .filter(t -> t.getTrader().getCity().equals(city))
                    .map(Java8StreamsTransaction::getValue)
                    .reduce(0, (a, v) -> a + v)
        );
    }

    public static int findHighestValue(List<Java8StreamsTransaction> transactions) {
        return transactions.stream()
                .map(Java8StreamsTransaction::getValue)
                .max(comparing(v -> v)).orElse(0); // returns Optional
    }

    public static Java8StreamsTransaction findTransactionWithSmallestValue(List<Java8StreamsTransaction> transactions) {
        return transactions.stream()
                .min(comparing(Java8StreamsTransaction::getValue)).orElse(null);
    }
}
