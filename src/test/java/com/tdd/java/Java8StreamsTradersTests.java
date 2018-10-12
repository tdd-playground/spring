package com.tdd.java;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Java8StreamsTradersTests {

    private Java8StreamsTrader raoul;
    private Java8StreamsTrader mario;
    private Java8StreamsTrader alan;
    private Java8StreamsTrader brian;
    private List<Java8StreamsTransaction> transactions;

    @Before
    public void setUp() throws Exception {
        raoul = new Java8StreamsTrader("Raoul", "Cambridge");
        mario = new Java8StreamsTrader("Mario", "Milan");
        alan = new Java8StreamsTrader("Alan", "Cambridge");
        brian = new Java8StreamsTrader("Brian", "Cambridge");
        transactions = Arrays.asList(
                new Java8StreamsTransaction(brian, 2011, 300),
                new Java8StreamsTransaction(raoul, 2012, 1000),
                new Java8StreamsTransaction(raoul, 2011, 400),
                new Java8StreamsTransaction(mario, 2012, 710),
                new Java8StreamsTransaction(mario, 2012, 700),
                new Java8StreamsTransaction(alan, 2012, 950)
        );
    }

    // Find all transactions in the year 2011 and sort them by value (high to small).
    @Test
    public void findTransactionsByYear_passTransactions_returnSortedList() {
        List<Java8StreamsTransaction> output = Java8StreamsTraders.findTransactionsByYear(transactions);
        assertThat(output).containsExactly(
                transactions.get(2),
                transactions.get(0)
        );
    }

    // What are all the unique cities where the traders work?
    @Test
    public void findUniqueCities_passTransactions_returnListUniqueCities() {
        List<String> output = Java8StreamsTraders.findUniqueCities(transactions);
        assertThat(output).containsExactly("Cambridge", "Milan");
    }

    // Find all traders from Cambridge and sort them by name.
    @Test
    public void findTradersFromCity_passTransactions_returnSortedNameList() {
        List<String> output = Java8StreamsTraders.findTradersByCity(transactions);
        assertThat(output).containsExactly("Alan", "Brian", "Raoul");
    }

    // Return a string of all traders’ names sorted alphabetically.
    @Test
    public void returnNamesAsDelimitiedString_passTransactions_returnDelimitiedString() {
        String output = Java8StreamsTraders.returnNamesAsDelimitiedString(transactions);

        assertThat(output).isEqualTo("Alan, Brian, Mario, Raoul");
    }

    // Are any traders based in Milan?
    @Test
    public void isBasedInCity_passTransactions_returnListTraders() {
        boolean output = Java8StreamsTraders.isBasedInCity(transactions, "Milan");

        assertThat(output).isTrue();
    }

    // Print all transactions’ values from the traders living in Cambridge.
    @Test
    public void printValuesFromTradersInGivenCity_passTransactions_noReturn() {
        Java8StreamsTraders.printValuesFromTradersInGivenCity(transactions, "Milan");
        // No return so no asserts :(
    }

    // What’s the highest value of all the transactions?
    @Test
    public void findHighestValue_passTransactions_returnHighestValue() {
        int output = Java8StreamsTraders.findHighestValue(transactions);

        assertThat(output).isEqualTo(1000);
    }

    // Find the transaction with the smallest value.
    @Test
    public void findTransactionWithSmallestValue_passTransactions_returnTransaction() {
        Java8StreamsTransaction output = Java8StreamsTraders.findTransactionWithSmallestValue(transactions);

        assertThat(output).isEqualTo(transactions.get(0));
    }

}
