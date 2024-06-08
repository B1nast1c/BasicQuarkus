package project;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

import java.util.logging.Logger;

// Mismo tiempo de vida para toda la aplicación
// Una sola instancia por aplicación
@ApplicationScoped
public class ApplicationScopeBean {
  private static final Logger logger = Logger.getLogger("ListenerBean");

  // Ejecución al inicio
  void onStart(@Observes StartupEvent init) {
    logger.info("Application is starting");
  }

  // Ejecución al final
  void onShutdown(@Observes ShutdownEvent end) {
    logger.info("Application is shutting down");
  }
}
