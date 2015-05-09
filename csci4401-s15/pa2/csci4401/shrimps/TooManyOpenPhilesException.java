package csci4401.shrimps;

/**
 * The system has reached the maximum number of files that can be opened concurrently.
 */
public class TooManyOpenPhilesException extends Exception {
    public TooManyOpenPhilesException() {}
    public TooManyOpenPhilesException( String message) { super( message);}
}
