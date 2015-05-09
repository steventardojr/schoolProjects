package StudentExample;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class StudentTest {
  public static void main (String[] args) throws Exception {
   /**
    * Create a new ArrayList for the list of students
    * Create a new file containing the list of students
    * Create a scanner to read the list of students in the file into the ArrayList
    *
    */
   ArrayList<Student> students = new ArrayList<Student>();
   File input = new File("/Users/steven/Documents/CSCI_HW/csci1583/homework5/StudentExample/Students.txt");
   Scanner reader = new Scanner(input);
  
   /**
    * Using a while loop, read each student into an array of strings
    * Add the student's info into a Student object
    * Add the student's object into the ArrayList of students
    *
    */
   while(reader.hasNextLine()) {
     String[] studentData = reader.nextLine().split(" ");
     String name = studentData[0] + " " + studentData[1];
     int id = Integer.parseInt(studentData[2]);
     Student student = new Student(id, name, studentData[3]);
     students.add(student);
   }
 }
}
