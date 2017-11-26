package ftw.steve.simpleblockchain.model;

import com.google.common.hash.Hashing;

import java.nio.charset.Charset;
import java.util.Date;

public class Block {

    private long index;
    private Date timestamp;
    private BlockData data;
    private String previousBlocksHash;
    private String blocksHash;

    public Block(long index, Date timestamp, BlockData data, String previousBlocksHash) {
        this.index = index;
        this.timestamp = timestamp;
        this.data = data;
        this.previousBlocksHash = previousBlocksHash;
        this.blocksHash = generateHashForBlock();
    }

    private String generateHashForBlock() {
        String hashThis = String.valueOf(this.index) + "::" + this.timestamp +
                "::" + this.data + "::" + this.previousBlocksHash;
        return Hashing.sha256().hashString(hashThis, Charset.forName("UTF-8")).toString();
    }

    public long getIndex() {
        return index;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public BlockData getData() {
        return data;
    }

    public String getPreviousBlocksHash() {
        return previousBlocksHash;
    }

    public String getBlocksHash() {
        return blocksHash;
    }
}
