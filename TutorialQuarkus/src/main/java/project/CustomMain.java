package project;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.ws.rs.ApplicationPath;

// Clase para la ejecución directa desde el IDE, sin necesidad de usar la terminal
@QuarkusMain
// @ApplicationPath("/test/") // RequestMapping
public class CustomMain { // Misma estructura de una clase base que se usa en Spring
  public static void main(String ... args) {
    System.out.println("Custom main method");
    Quarkus.run(args);
  }
}
