package rest.addressbook.web;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import security.service.JWTService;
import security.service.domain.Credentials;
import security.service.domain.Jws;

@Path("/login")
public class AuthenticationController {

  @Inject
  JWTService jwtService;

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response authenticateUser(Credentials credentials) {

    String username = credentials.getUsername();
    String password = credentials.getPassword();

    try {

      // Authenticate the user using the credentials provided
      authenticate(username, password);

      // Issue a token for the user
      String token = issueToken(username);
      System.out.println(token);

      Jws jws = new Jws(token);
      System.out.println(jws);
      // Return the token on the response
      return Response.ok(jws).build();

    } catch (Exception e) {
      return Response.status(Response.Status.FORBIDDEN).build();
    }
  }

  private void authenticate(String username, String password) {
    System.out.println("Autenticado"); // Dummy Authentication method
  }

  private String issueToken(String username) {
    return jwtService.createJWT(username);
  }


}

