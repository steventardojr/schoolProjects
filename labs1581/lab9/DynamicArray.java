/**
 * DynamicArray Class
 * Lab Nine
 **/

public class DynamicArray {
  private String[] array;
  private int numberOfElements;
  private int index;

  public DynamicArray() {
    this.numberOfElements = 0;
    this.array = new String[10];
    this.index = 0;
  }

  public DynamicArray(int size) {
    this.array = new String[size];
    this.numberOfElements = 0;
    this.index = 0;
  }

  public DynamicArray(String[] a) {
    this.array = a.clone();
    this.numberOfElements = a.length;
    this.index = a.length;
  }

  public void add(String s) {
    if (this.index >= this.array.length) {
      expandArray();
    }
    this.array[index] = s;
    this.numberOfElements++;
    this.index++;
  }

  public void expandArray() {
    String[] temp = new String[(int)(this.array.length + (this.array.length * 0.5))];
    for (int i = 0; i < this.array.length; i++) {
      temp[i] = array[i];
    }
    this.array = temp;
  }

  public void add(String s, int ind) {
    if (ind >= (this.array.length) || ind < 0) {
      System.out.println("The index typed is incorrect!");
    }
    else {
      this.array[ind] = s;
      this.index++;
      this.numberOfElements++;
    }
  }

  public void remove(int ind) {
    if (ind >= (this.array.length) || ind < 0) {
      System.out.println("The index typed is incorrect!");
    }
    else {
      for (int i = ind; i < (this.array.length - ind - 1); i++) {
        this.array[i] = this.array [i+1];
      }
      this.array[this.array.length - 1] = null;
      this.index--;
      this.numberOfElements--;
    }
  }

  public String get(int ind) {
    if (ind >= (this.array.length) || ind < 0) {
      System.out.println("The index typed is incorrect!");
    }
    return this.array[ind];
  }

  public boolean isEmpty() {
    return this.numberOfElements == 0;
  }

  public int sizeOf() {
    return this.numberOfElements;
  }
}
