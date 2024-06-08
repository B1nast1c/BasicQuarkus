package project;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import project.customRest.entity.Person;
import project.customRest.service.PersonService;

import javax.print.attribute.standard.Media;
import java.util.List;

@Path("/hello") // Request Mapping
public class ExampleResource {

  @Inject
  private PersonService personService;

  @ConfigProperty(name = "greeting") // Almacenamiento de valores en el properties
  private String customSalute;

  @GET //GetMapping
  @Produces(MediaType.TEXT_PLAIN)
  public String hello() {
    return "Hello from Quarkus REST";
  }

  @GET
  @Path("/custom/{userName}")
  @Produces(MediaType.TEXT_PLAIN)
  public String customGreeting(@PathParam("userName") String username) { //PathVariable en SpringBoot
    return customSalute + " " + username;
  }

  @GET
  @Path("/person/all")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Person> getPerson() {
    return personService.getAllPersons();
  }
}
