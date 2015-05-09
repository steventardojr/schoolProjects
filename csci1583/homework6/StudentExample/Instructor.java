package StudentExample;

/**
 * Models an intstructor in the UNO Webstar system
 */
public class Instructor extends Associate {
  private int coursesPerSemester;

  /**
   * requires: id >= 2000000 && id <= 2999999
   *           name ~= /Last, First/
   *           defaultPassword.length() >= 15
   * 
   * ensures: this.coursesPerSemester() >= 0       
   * 
   */
  public Instructor( int id, String name, String defaultPassword ) {
    super(id, name, defaultPassword);
    coursesPerSemester = 0;
  }

  /**
   * Return the number of courses of this instructor
   */
  public int coursesPerSemester() {
    return coursesPerSemester;
  }

  /**
   * Update the number of courses for this instructor
   * 
   * requires: courses >= 0
   * 
   * ensures: new.coursesPerSemester() == old.coursesPerSemester() + courses
   * 
   */
  public void addCourse(int courses) {
    if (coursesPerSemester < 4) {
      coursesPerSemester = coursesPerSemester + courses;
    }
  }
}
