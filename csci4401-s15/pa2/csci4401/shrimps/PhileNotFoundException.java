package csci4401.shrimps;

/**
 * An attempt has been made to operate on a file that does not exist.
 */
public class PhileNotFoundException extends Exception {
    public PhileNotFoundException() {}
    public PhileNotFoundException( String message) { super( message);}
}
