package ftw.steve.simpleblockchain.model;

public class Transaction {

    private String from;
    private String to;
    private double amount;

    public Transaction() {}

    public Transaction(String from, String to, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public double getAmount() {
        return amount;
    }
}
