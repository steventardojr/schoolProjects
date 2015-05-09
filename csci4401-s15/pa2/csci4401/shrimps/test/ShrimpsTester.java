package csci4401.shrimps.test;

import java.io.*;
import csci4401.shrimps.*;

public class ShrimpsTester {
    public static Shrimps shrimps = null;
    public static RawDisk disk = null;

    public static void main( String[] argv) throws Exception {
	int diskSize = 1024;
	disk = new RawDiskImpl( diskSize);
	System.out.println( "Disk Size: " + disk.getSize());
	shrimps  = testStartup( disk);
	byte[] buffer = getTestBuffer();
	Phile phile = testCreate( shrimps, buffer, "file");
	shrimps.close( phile);
	ls( shrimps);
	System.err.println( shrimps);
	powerCycle();
	ls( shrimps);
	upload( argv[0]);
	compare( argv[0]);
	cat( argv[0]);
	powerCycle();
	cat( argv[0]);
	for( int i=0; i<3; i++) {
	    initDisk( (i+1)*diskSize);
	    System.out.println( "Disk size: " + disk.getSize() + " MaxFiles: " + maxFiles());
	    powerCycle();
	    System.out.println( "Disk size: " + disk.getSize() + " MaxFiles: " + maxFiles());
	}
	for( int i=0; i<3; i++) {
	    initDisk( (i+1)*diskSize);
	    System.out.println( "Disk size: " + disk.getSize() + " MaxFileSize: " + maxFileSize());
	    powerCycle();
	    ls( shrimps);
	}
	testReclaim();
    }
    static void testReclaim() {
	try {
	    initDisk( 256);
	    System.out.println( "Reclaim test ...");
	    int max = maxFiles();
	    System.out.println( "CLEAN DISK: " + disk.getSize() + " MaxFiles: " + max);
	    String[] dir = shrimps.list();; 
	    for( int i=0; i<dir.length; i++)
		shrimps.delete( dir[i]);
	    powerCycle();
	    ls( shrimps);
	    System.out.println( "RECLAIMED DISK: " + disk.getSize() + " MaxFiles: " + maxFiles());
	} catch( Exception ex) {  System.out.println( "!!!testReclaim: " + ex.getClass().getName()); }
    }
	
	
    static int maxFiles() {
	int count = 0;
	try {
	    Phile phile = shrimps.create( "file." + count);
	    while( phile != null) {
		shrimps.close( phile);
		count++;
		phile = shrimps.create( "file." + count);
	    }
	    shrimps.close( phile);
	} catch( DiskFullException ex) {
	    return count;
	} catch( Exception ex) {  System.out.println( "!!!maxFiles: " + ex.getClass().getName()); }
	return count;
    }
    static int maxFileSize() {
	Phile phile = null;
	byte[] buffer = getTestBuffer();  
	int maxCount = (disk.getSize()*RawDisk.BLOCK_SIZE)/buffer.length+1;
	int count = 0, written = 0;
	try {
	    phile = shrimps.create( "BigFile");
	    while( phile != null && count < maxCount) {
		written += phile.write( buffer, buffer.length);
		count++;
	    }
	    if( phile.getSize() != written)
		System.out.println( "!!!maxFileSize: " + "written: " + written + " BigFile.getSize() = " + phile.getSize());
	    shrimps.close( phile);
	} catch( DiskFullException ex) {
	    try { shrimps.close( phile); } catch( Exception e) {}
	    return written;
	} catch( Exception ex) { System.out.println( "!!!maxFileSize: " + ex.getClass().getName()); }
	return count;
    }
    static Shrimps testStartup( RawDisk disk) {
	System.out.print("Testing startup ...");
	try {
	    Shrimps shrimps = new ShrimpSystem();
	    shrimps.format(disk);
	    shrimps.shutdown();
	    shrimps = new ShrimpSystem();
	    shrimps.startup(disk);
	    System.out.println( "OK");
	    return shrimps;
	} catch( Exception ex) {
	    ex.printStackTrace();
	    System.out.println( ex.getClass().getName()); 
	}
	return shrimps;
    }
    static Phile testCreate( Shrimps shrimps, byte[] buffer, String fileName) {
	System.out.print( "Testing create ... ");
	try {
	    Phile phile = shrimps.create(fileName);
	    phile.write( buffer, buffer.length);
	    System.out.println( "OK");
	    return phile;
	} catch( Exception ex) { 
	    ex.printStackTrace();
	    System.out.println( ex.getClass().getName()); 
	}
	return null;
    }
    static void ls( Shrimps shrimps) {
	try {
	    String[] files = shrimps.list();
	    System.out.println( "> ls ... ");
	    for( int i=0; i<files.length; i++) {
		Phile phile = shrimps.open( files[i], 0);
		System.out.println("\t" + files[i] + "\t\t" + phile.getSize());
		shrimps.close( phile);
	    }
	    System.out.println("\tTotal files: " + files.length);
 	} catch( Exception ex) { System.out.println( ex.getClass().getName()); }
    }
    static void cat( String file) {
	try {
	    System.out.println("> cat " + file);
	    Phile phile = shrimps.open( file, 0);
	    int read = 0;
	    byte[] buffer = new byte[phile.getSize()];
	    phile.read( buffer, buffer.length);
	    for( int i=0; i<buffer.length; i++)
		System.out.print( (char)buffer[i]);
	    System.out.println( "\nSize: " + buffer.length);
 	} catch( Exception ex) { System.out.println( ex.getClass().getName()); }

    }
    static void upload( String realFile) {
	try {
	    System.out.print( "> upload '" + realFile + "'");
	    byte[] buffer = new byte[RawDisk.BLOCK_SIZE];
	    FileInputStream fis = new FileInputStream( new File( realFile));
	    Phile phile = shrimps.create( realFile);
	    int count = fis.read( buffer);
	    System.out.print( "  File size: " + count);
	    //for( int i=0; i<buffer1.length; i++)file
	    //	System.out.print( (char)buffer1[i]);
	    //System.out.println();
	    while( count > -1) {
		phile.write( buffer, count);
		count = fis.read( buffer);
	    }
	    fis.close();
	    shrimps.close( phile);
	    System.out.println( " OK");
	} catch( Exception ex) { System.out.println( ex.getClass().getName()); }
    }
    static void compare( String fileName) {
	System.out.println( "> compare '" + fileName + "'");
	byte[] buffer1 = new byte[RawDisk.BLOCK_SIZE];
	byte[] buffer2 = new byte[RawDisk.BLOCK_SIZE];
	try {
	    
	    Phile phile = shrimps.open( fileName, 0);
	    FileInputStream fis = new FileInputStream( fileName);
	    int count1 = fis.read( buffer1);
	    while( count1 > -1) {
		int count2 = phile.read( buffer2, buffer2.length);
		if( count1 != count2)
		    throw new Exception( "Error: init file sizes are different.");
		for( int i=0; i<count1; i++)
		    if( buffer1[i] != buffer2[i])
			throw new Exception( "Error: diff @ location " + i);
		//else
		//	System.out.print( buffer2[i] + " ");
		count1 = fis.read( buffer1);
	    }
	    shrimps.close( phile);
	    System.out.println( "> '" + fileName + "' copied successfully.");
	} catch( Exception ex) { ex.printStackTrace();}
	//	} catch( Exception ex) { System.out.println( "!!!compare: " + ex.getClass().getName());}
    }
    static void initDisk( int size) {
	disk = new RawDiskImpl( size);
	shrimps = new ShrimpSystem();
	shrimps.format( disk);
	shrimps.startup( disk);
    }
    static void powerCycle() {
	shrimps.shutdown();
	shrimps = new ShrimpSystem();
	shrimps.startup( disk);
 	System.out.println( "Off/On");
    }
    static byte[] getTestBuffer() {
	byte[] res = new byte[256];
	for( int i=0; i<res.length; i++)
	    res[i] = (byte)i;
	return res;
    }
}

