package csci4401.shrimps;

/**
 * This is the one of the two interfaces that the file system must implement and presents to the application with a
 * file system abstraction.
 * @see Phile
 */
public interface Shrimps {
    /** Maximum number of concurrently open files. */
    public static final int MAX_OPEN = 16;
    /** 
     * Create, opens, and seek byte 0 for a new file-the file must <b>NOT</b> 
     * already exist.
     * @param name Name for the file to be created.
     * @return A reference to the created file.
     * @exception PhileAlreadyExistsException The file name given is already in use by an existing file.
     * @exception DiskFullException There is not enough free space left on the device to create a new file.
     */
    public Phile create( String name) throws PhileAlreadyExistsException, DiskFullException; 
    /** 
     * Deletes an existing file.
     * @param name Name for the file to be deleted.
     * @exception PhileNotFound File cannot be deleteed because it does not exist.
     */
    public void delete( String name) throws PhileNotFoundException;
    /**
     * Open an existing file and seek byte 0.  This method has no effect if the file is already open.  
     * @param name Human-readable file name
     * @param mode Mode in which the file is opened. If the parameter is 0 the file is read-only, read/write otherwise.
     * @return An open file at position 0.
     * @exception PhileNotFound File cannot be opened because it does not exist.
     */
    public Phile open( String name, int mode) throws PhileNotFoundException, TooManyOpenPhilesException;
    /**
     * Close the given file.
     * @param name Name of the file to be opened.
     * @param mode Mode in which the file is to be opened: <code>mode == 0  --> read-only</code>
     *                                                     <code>mode != 0  --> read/write</code>
     * @see Phile
     * @exception PhileNotOpenException An attempt has been made to close a file that is either <code>null</null>
     *    or already closed.
     */
    public void close( Phile phile) throws PhileNotOpenException;

    /**
     * Provide a list of all file names.
     * @return An array of the names of all files in the file system, <code>null</code> if no files exist.
     */
    public String[] list();
    /**
     * Creates a blank file system on the raw disk.
     * @param disk The disk to be formatted.
     */
    public void format( RawDisk disk);
    /**
     * Loads the file system (sets up in-memory structures) from the given disk.
     * @param disk The disk from which the file system is to be loaded
     */
    public void startup( RawDisk disk);
    /**
     * Shut down a file system - close all files and commit to disk all memory structures.
     */
    public void shutdown();
}
