package StudentExample;

/**
 * Models an intstructor in the UNO Webstar system
 */
public class Instructor {
  private int id;
  private String password;
  private String name;
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
    this.id = id;
    this.name = name;
    password = defaultPassword;
    coursesPerSemester = 0;
  }

  /**
   * Return the id of this instructor
   */
  public int id() {
    return id;
  }

  /**
   * Return the name of this instructor
   */
  public String name() {
    return name;
  }

  /**
   * Return the number of courses of this instructor
   */
  public int coursesPerSemester() {
    return coursesPerSemester;
  }

  /**
   * Update the name for this instructor
   *
   * requires: newName ~= /Last, First/
   *
   */
  public void changeName(String newName) {
    name = newName;
  }

  /**
   * Update the password for this instructor
   *
   * requires: newPassword.length() <= 15
   *
   */
  public void changePassword(String newPassword) {
    password = newPassword;
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
