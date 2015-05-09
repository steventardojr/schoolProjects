package csci4401.shrimps;

/**
 * A trivial (and clearly sub-optimal) implementation of a raw disk.
 * Not properly tested yet!
 */
public class RawDiskImpl implements RawDisk {
    private byte[][] disk;
    private int diskSize;

    public RawDiskImpl( int diskSize) {
	this.diskSize = diskSize; 
	disk = new byte[diskSize][];
    }
    public void format() {
	disk = new byte[diskSize][];
    }
    public int getSize() { 
	return diskSize;
    }
    public void writeBlock( byte[] buffer, int blockNum) throws BadBlockException {
	if( blockNum < 0 || blockNum >= diskSize)
	    throw new BadBlockException( "Illegal block number: " + blockNum);
	// This will also throw NullPointerException if buffer is NULL
	if( buffer.length != BLOCK_SIZE) 
	    throw new BadBlockException( "Wrong buffer size: " + buffer.length);
	// Clone the buffer first
	byte[] block = new byte[BLOCK_SIZE];
	for( int i=0; i<BLOCK_SIZE; i++)
	    block[i] = buffer[i];
	disk[blockNum] = block;
    }
    public byte[] readBlock( int blockNum) throws BadBlockException {
	if( blockNum < 0 || blockNum >= diskSize)
	    throw new BadBlockException( "Illegal block number: " + blockNum);
  	// Clone the buffer first
	byte[] block = new byte[BLOCK_SIZE];
	for( int i=0; i<BLOCK_SIZE; i++)
	    block[i] = disk[blockNum][i];
	return block;
    }  
}
