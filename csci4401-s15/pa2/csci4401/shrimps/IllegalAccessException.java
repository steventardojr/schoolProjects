package csci4401.shrimps;

/**
 * Thrown whenever a read beyond EOF is attempted or a write on a file opened as read-only.
 */
public class IllegalAccessException extends Exception {
    public IllegalAccessException() {}
    public IllegalAccessException( String message) { super( message);}
}
