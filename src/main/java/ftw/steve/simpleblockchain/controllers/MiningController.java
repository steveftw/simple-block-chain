package ftw.steve.simpleblockchain.controllers;

import ftw.steve.simpleblockchain.model.Block;
import ftw.steve.simpleblockchain.services.MiningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MiningController {

    private MiningService miningService;

    @Autowired
    public MiningController(MiningService miningService) {
        this.miningService = miningService;
    }

    @GetMapping("/mine")
    @CrossOrigin("*")
    public Block mineNewBlock() {
        return miningService.mineBlock();
    }

}
