package security.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

public class JWTService {

  Key key;

  public JWTService() {
    key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
  }

  public String createJWT(String username) {
    return Jwts.builder().setSubject(username).signWith(key).compact();
  }

  public void verifyJWT(String jws) {
    Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jws);
  }
}
