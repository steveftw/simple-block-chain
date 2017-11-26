package ftw.steve.simpleblockchain.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlockChain {

    private List<Block> chain;
    private Block previousBlock;

    public BlockChain() {
        this.previousBlock = createGenesisBlock();
        this.chain = new ArrayList<>();
        this.chain.add(previousBlock);
    }

    private Block createGenesisBlock() {
        return new Block(0, new Date(), "Genesis Block", "0");
    }

    public Block generateNextBlock(String data) {
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

}
