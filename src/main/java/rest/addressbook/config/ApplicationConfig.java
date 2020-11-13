package rest.addressbook.config;

import org.eclipse.persistence.jaxb.rs.MOXyJsonProvider;
import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import rest.addressbook.domain.AddressBook;
import rest.addressbook.web.AddressBookController;
import rest.addressbook.web.AuthenticationController;
import security.service.JWTService;

public class ApplicationConfig extends ResourceConfig {

  /**
   * Default constructor
   */
  public ApplicationConfig() {
    this(new AddressBook(), new JWTService());
  }


  /**
   * Main constructor
   *
   * @param addressBook a provided address book
   */
  public ApplicationConfig(final AddressBook addressBook, JWTService jwtService) {
    register(AddressBookController.class);
    register(MOXyJsonProvider.class);
    register(AuthenticationController.class);
    register(new AbstractBinder() {

      @Override
      protected void configure() {
        bind(addressBook).to(AddressBook.class);
        bind(jwtService).to(JWTService.class);
      }
    });
  }

}
