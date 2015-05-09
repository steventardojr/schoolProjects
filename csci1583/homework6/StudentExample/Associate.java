package StudentExample;

/**
 * Models an associate in the UNO Webstar system
 */
public class Associate {
  private int id;
  private String password;
  private String name;
  
  /**
   * requires: id >= 2000000 && id <= 2999999
   *           name ~= /Last, First/
   *           defaultPassword.length() >= 15
   * 
   */
  public Associate(int id, String name, String defaultPassword) {
    this.id = id;
    this.name = name;
    password = defaultPassword;
  }
  
  /**
   * Return the id of this associate
   */
  public int id() {
    return id;
  }

  /**
   * Return the name of this associate
   */  
  public String name() {
    return name;
  }

  /**
   * Update the name of this associate
   *
   * requires: newName =~ /Last, First/
   *
   */
  public void changeName(String newName) {
    name = newName;
  }

  /**
   * Update the password for this associate
   *
   * requires: newPassword.length() >= 15
   *
   */
  public void changePassword(String newPassword) {
    password = newPassword;
  }
}
