package booking;

import java.util.LinkedList;
import java.util.Queue;

public class TransactionSystem {
    private Queue<String> transactions = new LinkedList<>();

    public void addTransaction(String transaction) {
        transactions.add(transaction);
    }

    public void processTransactions() {
        while (!transactions.isEmpty()) {
            System.out.println("Processing transaction: " + transactions.poll());
        }
    }
}
