package csci4401.shrimps;

/**
 * An attempt has been made to create a file that already exists.
 */
public class PhileAlreadyExistsException extends Exception {
    public PhileAlreadyExistsException() {}
    public PhileAlreadyExistsException( String message) { super( message);}
}
