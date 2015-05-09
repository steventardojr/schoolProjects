package StudentExample;

import java.util.ArrayList;

public class Course {
  private int courseNumber;
  private String title;
  private Instructor instructor;
  private ArrayList<Student> students;

  /**
   * requires: courseNumber >= 0
   *           title = /Title of Course/
   *           instructor to be previously initialized
   *           students to be previously initialized      
   * 
   */
  public Course(int courseNumber, String title, Instructor instructor, ArrayList<Student> students) {
    this.courseNumber = courseNumber;
    this.title = title;
    this.instructor = instructor;
    this.students = students;
  }

  /**
   * Return the course number
   */
  public int courseNumber() {
    return courseNumber;
  }

  /**
   * Return the title of the course
   */
  public String title() {
    return title;
  }

  /**
   * Return the instructor of the course
   */
  public Instructor instructor() {
    return instructor;
  }

  /**
   * Return the students in the course
   */
  public ArrayList students() {
    return students;
  }

  /**
   * Change the course number
   *
   * requires: newCourseNumber >= 0;
   *
   */
  public void changeCourseNumber(int newCourseNumber) {
    courseNumber = newCourseNumber;
  }

  /**
   * Change the title of the course
   *
   * requires: newTitle = /New Title of Course/
   *
   */
  public void changeTitle(String newTitle) {
    title = newTitle;
  }

  /**
   * Change the instructor of the course
   *
   * requires: newInstructor to have been previously initialized
   *
   */
  public void changeInstructor(Instructor newInstructor) {
    instructor = newInstructor;
  }

  /**
   * Update the students in the class
   *
   * requires: newStudents to have been previously initialized
   *           and updated with current list of students
   *
   */
  public void updateStudents(ArrayList<Student> newStudents) {
    students = newStudents;
  }
}
