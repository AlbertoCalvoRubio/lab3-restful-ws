package security.service.domain;

import java.io.Serializable;

public class Credentials implements Serializable {

  private String username;
  private String password;

  public Credentials(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public Credentials() {
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  // Getters and setters omitted
}