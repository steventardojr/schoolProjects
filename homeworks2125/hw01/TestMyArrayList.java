/**
 * Steven Tardo
 * CSCI 2125, Spring 2015
 * 3 February 2015
 * Homework 1, An implementation of the Java class ArrayList
 * This class is a JUnit test class that tests each method
 * of the MyArrayList class to ensure they function properly.
 */

import org.junit.*;
import static org.junit.Assert.*;

public class TestMyArrayList {
    @Test
    public void testAdd() {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(1);
        myArrayList.add(1);
        assertTrue(myArrayList.size() == 3);
        assertTrue(myArrayList.toString().equals("[1, 1, 1]"));
    }

    @Test
    public void testRemove() {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        assertTrue(myArrayList.size() == 3);
        myArrayList.remove(0);
        assertTrue(myArrayList.size() == 2);
        assertTrue(myArrayList.toString().equals("[2, 3]"));
        myArrayList.remove(1);
        myArrayList.remove(0);
        assertTrue(myArrayList.size() == 0);
        assertTrue(myArrayList.toString().equals("[]"));
    }

    @Test
    public void testSize() {
        MyArrayList myArrayList = new MyArrayList();
        assertTrue(myArrayList.size() == 0);
        myArrayList.add(1);
        assertTrue(myArrayList.size() == 1);
        myArrayList.remove(0);
        assertTrue(myArrayList.size() == 0);
    }

    @Test
    public void testToString() {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(0);
        myArrayList.add(1);
        myArrayList.add(2);
        assertTrue(myArrayList.toString().equals("[0, 1, 2]"));
        myArrayList.remove(2);
        assertTrue(myArrayList.toString().equals("[0, 1]"));

    }
}