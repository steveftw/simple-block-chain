package ftw.steve.simpleblockchain.controllers;

import ftw.steve.simpleblockchain.model.Transaction;
import ftw.steve.simpleblockchain.services.TransactionsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionsController.class);

    private TransactionsService transactionsService;

    @Autowired
    public TransactionsController(TransactionsService transactionsService) {
        this.transactionsService = transactionsService;
    }

    @PostMapping("/transactions")
    @CrossOrigin("*")
    public String createTransaction(@RequestBody Transaction transaction) {
        LOGGER.info("New Transaction:");
        LOGGER.info("\t FROM: {}", transaction.getFrom());
        LOGGER.info("\t TO: {}", transaction.getTo());
        LOGGER.info("\t AMOUNT: {}", transaction.getAmount());
        transactionsService.addTransaction(transaction);
        return "Transaction submitted successfully!";
    }

}
