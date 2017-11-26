package ftw.steve.simpleblockchain.services;

import com.google.common.collect.Lists;
import ftw.steve.simpleblockchain.model.Transaction;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionsService {

    private List<Transaction> transactions;

    @PostConstruct
    private void postConstruct() {
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public List<Transaction> getAllTransactions() {
        List<Transaction> trxs = Lists.newArrayList(this.transactions);
        this.transactions.clear();
        return trxs;
    }
}
