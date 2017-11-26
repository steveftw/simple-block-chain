package ftw.steve.simpleblockchain;

import ftw.steve.simpleblockchain.model.Block;
import ftw.steve.simpleblockchain.model.BlockChain;

public class Application {

    public static void main(String[] args) {
        BlockChain blockChain = new BlockChain();

        for (int i = 0; i < 20; i++) {
            Block newBlock = blockChain.generateNextBlock("My block #" + i);

            System.out.println("Block #" + newBlock.getIndex() + " has been added to the blockchain!");
            System.out.println("Hash: " + newBlock.getBlocksHash() + "\n");

            blockChain.addBlockToChain(newBlock);
        }
    }

}
