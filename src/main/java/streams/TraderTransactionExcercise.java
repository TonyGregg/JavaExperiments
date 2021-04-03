package streams;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/** Created by Antony Genil Gregory on 5/4/2019 12:17 PM For project : JavaProfessionalCert */
public class TraderTransactionExcercise {

  public static void main(String[] args) {
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Brooklyn");

    List<Transaction> transactions =
        Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 150),
            new Transaction(mario, 2012, 2710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950));

    // Q1) Find all transactions in 2011 and sort by value (small to high)
    List<Transaction> trxs2011Sorted =
        transactions.stream()
            .filter(transaction -> transaction.getYear() == 2011)
            .sorted(comparing(Transaction::getValue))
            .collect(toList());
    System.out.println("2011 transactions sorted from small to high : ");

    System.out.println(trxs2011Sorted);

    // Q2) Unique cities where the traders work?
    Set<String> uniqueCitiesOfTraders =
        transactions.stream()
            .map(transaction -> transaction.getTrader().getCity())
            .collect(toSet());

    System.out.println("Unique cities where traders worked");
    System.out.println(uniqueCitiesOfTraders);

    // Q3) Find all the traders from Cambridge and sort them by name

    List<Trader> cambridgeTraders =
        transactions.stream()
            .map(Transaction::getTrader)
            .filter(trader -> trader.getCity().equals("Cambridge"))
            .distinct() // Remove duplicates from the txs
            .sorted(comparing(Trader::getName))
            .collect(toList());

    System.out.println(cambridgeTraders);
    // Q4) Return a string of all traders' names alphabetically.

    final String allTradersName =
        transactions.stream()
            .map(transaction -> transaction.getTrader().getName())
            .distinct()
            .sorted()
            .reduce("", (a, b) -> a + ", " + b);
    System.out.println("All traders' name : " + allTradersName);

    final String allTraderNameUsingJoining =
        transactions.stream()
            .map(transaction -> transaction.getTrader().getName())
            .distinct()
            .sorted()
            .collect(Collectors.joining(", "));
    System.out.println("All traders' name using joining : " + allTraderNameUsingJoining);

    // Q5) Any traders based in Milan
    boolean isAnyMilanTrader =
        transactions.stream()
            .anyMatch(transaction -> transaction.getTrader().getCity().equalsIgnoreCase("Milan"));
    System.out.println("Is any Milan based trader ? " + isAnyMilanTrader);

    // Q6 - Print the values of all transactions from the traders living in Cambridge.
    List<Integer> cambridgeTrxValues =
        transactions.stream()
            .filter(transaction -> transaction.getTrader().getCity().equalsIgnoreCase("Cambridge"))
            .map(Transaction::getValue)
            .collect(toList());
    System.out.println("Cambridge based transaction values : " + cambridgeTrxValues);

    // Q7 -- Highest value of all the transactions.
    Optional<Integer> maximumTrxValueOptional =
        transactions.stream().map(Transaction::getValue).reduce(Integer::max);
    if (maximumTrxValueOptional.isPresent()) {
      System.out.println("Maximum value : " + maximumTrxValueOptional.get());
    }
    // Q8 - Find the transaction with the smallest value.
    Optional<Transaction> minimumTransaction =
        transactions.stream().min(comparing(Transaction::getValue));
    if (minimumTransaction.isPresent())
      System.out.println("Minimum value transaction " + minimumTransaction.get());

  }
}
