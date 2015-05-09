/**
 * Steven Tardo
 * CSCI 2125, Spring 2015
 * 3 February 2015
 * Homework 1, An implementation of the Java class ArrayList
 * This class is an implementation of the Java class ArrayList,
 * which allows for generic objects of the same type to be inserted
 * and removed from an array that automatically changes it size
 * accordingly. Functionality is also provided to place the contents
 * in a string and check the size of the list.
 */

public class MyArrayList {
	// Instance variables
    private Object[] data;
	private int size;

    // Constructor
	public MyArrayList() {
		this.size = 0;
		this.data = new Object[1];
	}

    /**
     * @param value - The object to be added to the array
     *
     * This method provides the functionality to add
     * a generic object to the end of the array
     */
	public void add (Object value) {
		if (this.size == 0)
            this.data[size] = value;
        else {
            Object[] newArray = new Object[this.data.length + 1];
            for (int i = 0; i < size; i++)
                newArray[i] = this.data[i];
            this.data = newArray;
            this.data[this.data.length - 1] = value;
        }
        size++;
	}

    /**
     * @param index - The index of the object to remove
     *
     * This method provides the functionality to remove
     * an object at the index being passed to the method
     */
	public void remove (int index) {
        this.data[index] = null;
        for (int i = index; i < size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
        if (this.size != 1)
            this.data[size - 1] = this.data[size - 2];
        size--;
    }

    /**
     * @return this.size
     *
     * This method returns the size of the array
     */
    public int size () {
        return this.size;
    }

    /**
     * @return output - The contents of the array in a String
     *
     * This method provides the functionality to place the
     * contents of the array in a String
     */
    public String toString() {
        String output = "[";
        if (size != 0) {
            for (int i = 0; i < this.size - 1; i++)
                output += (this.data[i] + ", ");
            output += this.data[size - 1];
        }
        output += "]";
        return output;
    }
}