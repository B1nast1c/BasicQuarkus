package project.customRest.service;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import project.customRest.entity.Person;
import project.customRest.repository.PersonRepository;

import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class PersonService {
  private static final Logger logger = Logger.getLogger("ListenerService");

  @Inject
  private PersonRepository repository;

  private void onStartup(@Observes StartupEvent init) {
    logger.info("Creating PersonService per application startup");
  }

  public List<Person> getAllPersons() {
    return repository.findAllPersons();
  }

  public Person getPersonById(String name) {
    return repository.findByName(name);
  }
}
