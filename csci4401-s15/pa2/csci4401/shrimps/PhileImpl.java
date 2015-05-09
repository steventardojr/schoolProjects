package csci4401.shrimps;

/**
 * This is the one of the two interfaces that the file system must implement and presents to the application with a
 * file abstraction.
 * @see Shrimps
 */
public class PhileImpl implements Phile {
    /** Open file in READ-ONLY mode */
    public static final int READ_ONLY = 0;
    /** Open file in READ/WRITE mode */
    public static final int READ_WRITE = 1;
	private String name;
	private RawDisk tempDisk;
	private int startingBlock;
	private int endingBlock;
	
	public PhileImpl(String name, RawDisk disk, int startingBlock, int endingBlock) {
		this.name = name;
		this.tempDisk = disk;
		this.startingBlock = startingBlock;
		this.endingBlock = endingBlock;
	}
	
    /**
     * Reads and returns readCount of data from the file, starting at the current file position (and advances the current possition).
     * If the remainder of the file is less the number of requested bytes (but greater than zero!) the
     * method should return whatever is left and NO exception should be raised.
     * If the current position is at the very end of a file and a read is attempted an "illegal access" exception
     * should be thrown.
     * @param buffer A buffer where the result should be placed.
     * @param readCount Number of bytes to be read, starting at the current position.
     * @exception PhileNotOpenException An operation is attempted on a closed file. 
     * @exception IllegalAccessException A read beyond EOF is attempted. 
     * @return Actual number of bytes read.
     */
    public int read( byte buffer[], int readCount) throws PhileNotOpenException, IllegalAccessException {
		int tempReadCount = readCount;
		int i = 0;
		while (i < tempReadCount && tempReadCount < 32) {
			try {
				buffer = tempDisk.readBlock(startingBlock);
				seek(1);
				tempReadCount++;
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
				tempReadCount = 0;
			}
			i++;
		}
		return tempReadCount;
	}
	
    /**
     * Writes writeCount of data at the current file position (and advances the current position).
     * @param buffer Data block to be written.
     * @param writeCount Number of bytes to be written, starting at the current position.
     * @exception PhileNotOpenException An operation is attempted on a closed file. 
     * @exception IllegalAccessException A write is attempted on a file opened as read-only.
     * @exception DiskFullException There is not enough free space left on the device to complete the request.
     * @return Actual number of bytes written.
     */
	public int write( byte buffer[], int writeCount) throws PhileNotOpenException, IllegalAccessException, DiskFullException {
		int tempWriteCount = writeCount;
		int i = 0;
		while (i < tempWriteCount && tempWriteCount < 32) {
			try {
				tempDisk.writeBlock(buffer, startingBlock);
				seek(1);
				tempWriteCount++;
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
			i++;
		}
		return tempWriteCount;
	}

    /**
     * Set the current file position. If the argument is non-positive - reset the position to the beginning of the file.
     * If the argument is greater than the current file size - go to the very end.
     * @param position The requested position.
     * @exception PhileNotOpenException An operation is attempted on a closed file. 
     */
    public void seek( int position) throws PhileNotOpenException {
    	startingBlock = startingBlock + position;
    }

    /** @return The current length of the file in bytes */
    public int getSize() throws PhileNotOpenException {
    	return endingBlock - startingBlock;
    }
}
