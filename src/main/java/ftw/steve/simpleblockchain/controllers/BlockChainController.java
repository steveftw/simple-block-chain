package ftw.steve.simpleblockchain.controllers;

import ftw.steve.simpleblockchain.model.Block;
import ftw.steve.simpleblockchain.services.BlockChainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlockChainController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlockChainService.class);

    private BlockChainService blockChainService;

    @Autowired
    public BlockChainController(BlockChainService blockChainService) {
        this.blockChainService = blockChainService;
    }

    @GetMapping("/blocks")
    @CrossOrigin("*")
    public List<Block> getAllBlocksInChain() {
        return blockChainService.getContentsOfBlockChain();
    }

}
