package StudentExample;

/**
 * Models a student in the UNO Webstar system
 */
public class Student {
  private int id;
  private String password;
  private String name;
  private int creditHours;
  private int qualityPoints; //invariant: qualityPoints <= 4.0 * creditHours && qualityPoints >= 0 
  private double gpa;
  
  /**
   * requires: id >= 2000000 && id <= 2999999
   *           name ~= /Last, First/
   *           defaultPassword.length() >= 15
   * 
   * ensures: this.creditHours() >= 0
   *          this.qualityPoints() >= 0
   *          this.gpa() >= 0.0          
   * 
   */
  public Student(int id, String name, String defaultPassword) {
    this.id = id;
    this.name = name;
    password = defaultPassword;
    creditHours = 0;
    qualityPoints = 0;
    gpa = 0.0;
  }
  
  /**
   * Return the id of this student
   */
  public int id() {
    return id;
  }

  /**
   * Return the name of this student
   */  
  public String name() {
    return name;
  }

  /**
   * Return the credit hours of this student
   */
  public int creditHours() {
    return creditHours;
  }

  /**
   * Return the quality points of this student
   */
  public int qualityPoints() {
    return qualityPoints;
  }

  /**
   * Return the GPA of this student
   */
  public double gpa() {
    return gpa;
  }

  /**
   * Update the name of this student
   *
   * requires: newName =~ /Last, First/
   *
   */
  public void changeName(String newName) {
    name = newName;
  }
  
  /**
   * Update credit hours for this student. This update should occur before 
   * adding quality points.
   * 
   * requires: hours >= 0
   * 
   * ensures: new.creditHours() == old.creditHours() + hours
   * 
   */
  public void addCreditHours(int hours) {
    creditHours = creditHours + hours;
  }
  
  /**
   * Update the quality points for this student
   * 
   * requires: (this.qualityPoints() + points) <= 4 * this.creditHours()
   *           points >= 0
   * ensures:
   *   new.qualityPoints() = old.qualityPoints() + points 
   *
   */ 
  public void addQualityPoints(int points) {
    if ((qualityPoints + points) <= 4 * creditHours) {
      qualityPoints = qualityPoints + points;
    }
  }
  
  /**
   * Update the password for this student
   *
   * requires: newPassword.length() >= 15
   *
   */
  public void changePassword(String newPassword) {
    password = newPassword;
  }
  
  /**
   * Calculates the grade point average of this student.
   * 
   * ensures: this.gpa() >= 0
   * 
   */
  public void computeGPA() {
    if (creditHours > 0) {
      gpa = (double)(qualityPoints) / creditHours;
    }
  }
}
