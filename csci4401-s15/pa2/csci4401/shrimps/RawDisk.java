package csci4401.shrimps;

/**
 * The API presented by the raw disk. Implementation of this interface is supplied.
 * @see RawDiskImpl
 */ 
public interface RawDisk {
    /** Size of simulated device blocks */
    public static int BLOCK_SIZE = 1024;
    /**
     * Cleans up the raw disk of any data.
     */
    public void format();
    /**
     * @return Total number of blocks.
     */
    public int getSize();
    /**
     * Writes a fixed size block with the given number.
     * @param blockNum number of the block to be written
     * @exception BadBlockException Either the buffer is not of size <code>BLOCK_SIZE</code>,
     *    or the given block number is illegal.
     */
    public void writeBlock( byte[] buffer, int blockNum) throws BadBlockException;
    /**
     * Reads a fixed size block with the given number.
     *
     * @param blockNum number of the block to be read
     * @return The contents of the block with the given number.
     * @exception BadBlockException The given block number is illegal.
     */
    public byte[] readBlock( int blockNum) throws BadBlockException;
}
