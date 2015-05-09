package csci4401.shrimps;

/**
 * Either the buffer is not of size <code>shrimps.RawDisk.BLOCK_SIZE</code>,
 * or the given block number is illegal.
 */
public class BadBlockException extends Exception {
    public BadBlockException() {}
    public BadBlockException( String message) { super( message);}
}
