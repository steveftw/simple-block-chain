package ftw.steve.simpleblockchain.model;

import java.util.List;

public class BlockData {

    private List<Transaction> transactions;
    private long proofOfWork;

    public BlockData(List<Transaction> transactions, long proofOfWork) {
        this.transactions = transactions;
        this.proofOfWork = proofOfWork;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public long getProofOfWork() {
        return proofOfWork;
    }

}
