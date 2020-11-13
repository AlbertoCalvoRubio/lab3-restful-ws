package security.service.domain;

public class Jws {
  String jws;

  public Jws(String jws) {
    this.jws = jws;
  }

  public Jws() {
  }

  public String getJws() {
    return jws;
  }

  public void setJws(String jws) {
    this.jws = jws;
  }


  @Override
  public String toString() {
    return "Jws{" +
        "jws='" + jws + '\'' +
        '}';
  }
}
