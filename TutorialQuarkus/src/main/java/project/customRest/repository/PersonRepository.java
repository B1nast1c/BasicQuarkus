package project.customRest.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import project.customRest.entity.Person;

import java.util.List;

@ApplicationScoped
public class PersonRepository implements PanacheMongoRepository<Person> {
  public Person findByName(String name) {
    return find("name", name).firstResult();
  }

  public List<Person> findAllPersons() {
    return Person.listAll();
  }
}
