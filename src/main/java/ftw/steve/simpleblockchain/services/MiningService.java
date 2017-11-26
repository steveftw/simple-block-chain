package ftw.steve.simpleblockchain.services;

import ftw.steve.simpleblockchain.model.Block;
import ftw.steve.simpleblockchain.model.BlockData;
import ftw.steve.simpleblockchain.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@PropertySource("classpath:application.yml")
public class MiningService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MiningService.class);

    private static final String PROPERTY_MINING_ADDRESS = "mining.address";

    private Environment env;
    private BlockChainService blockChainService;
    private TransactionsService transactionsService;

    @Autowired
    public MiningService(Environment env, BlockChainService blockChainService, TransactionsService transactionsService) {
        this.env = env;
        this.blockChainService = blockChainService;
        this.transactionsService = transactionsService;
    }

    public Block mineBlock() {
        LOGGER.info("Mining new block");
        Block lastBlock = blockChainService.getPreviousBlock();
        long lastProof = lastBlock.getData().getProofOfWork();
        LOGGER.info("About to run proof of work. Previous proof: {}", lastProof);
        long proof = proofOfWork(lastProof);
        LOGGER.info("New proof generated: {}", proof);
        transactionsService.addTransaction(new Transaction(
                "network",
                env.getRequiredProperty(PROPERTY_MINING_ADDRESS),
                1)
        );
        BlockData newBlockData = new BlockData(transactionsService.getAllTransactions(), proof);
        Block newBlock = new Block(
                lastBlock.getIndex() + 1,
                new Date(),
                newBlockData,
                lastBlock.getBlocksHash()
        );
        blockChainService.addBlockToChain(newBlock);
        LOGGER.info("New block successfully mined and added to chain.");
        return newBlock;
    }

    /**
     * Simple implementation of Proof of Work.
     * We simply increment a number until it is divisible by 9
     * and the result of the last successful proof.
     *
     * @param lastProof The last proof value.
     * @return The new proof.
     */
    private long proofOfWork(long lastProof) {
        long incrementor = lastProof + 1;
        while(!(incrementor % 9 == 0) || !(incrementor % lastProof == 0)) {
            LOGGER.info("\tWorking: {}", incrementor);
            incrementor++;
        }
        LOGGER.info("\tProof found: {}", incrementor);
        return incrementor;
    }

}
