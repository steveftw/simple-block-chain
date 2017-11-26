package ftw.steve.simpleblockchain.services;

import com.google.common.collect.Lists;
import ftw.steve.simpleblockchain.model.Block;
import ftw.steve.simpleblockchain.model.BlockData;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlockChainService {

    private List<Block> chain;
    private Block previousBlock;

    @PostConstruct
    public void postConstruct() {
        this.previousBlock = createGenesisBlock();
        this.chain = new ArrayList<>();
        this.chain.add(previousBlock);
    }

    private Block createGenesisBlock() {
        return new Block(
                0,
                new Date(),
                new BlockData(new ArrayList<>(), 9),
                "0");
    }

    public Block generateNextBlock(BlockData data) {
        return new Block(
                previousBlock.getIndex() + 1,
                new Date(),
                data,
                previousBlock.getBlocksHash()
        );
    }

    public void addBlockToChain(Block block) {
        this.chain.add(block);
        this.previousBlock = block;
    }

    public Block getPreviousBlock() {
        return this.previousBlock;
    }

    public List<Block> getContentsOfBlockChain() {
        return Lists.newArrayList(this.chain);
    }

}
