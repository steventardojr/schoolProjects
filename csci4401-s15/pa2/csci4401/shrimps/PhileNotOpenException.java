package csci4401.shrimps;

/**
 * Thrown whenever an file operation on closed file is attempted.
 */
public class PhileNotOpenException extends Exception {
    public PhileNotOpenException() {}
    public PhileNotOpenException( String message) { super( message);}
}
