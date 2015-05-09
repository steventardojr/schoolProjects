package csci4401.shrimps;

/**
 * Thrown whenever no more space can be allocated on the raw disk.
 */
public class DiskFullException extends Exception {
    public DiskFullException() {}
    public DiskFullException( String message) { super( message);}
}
