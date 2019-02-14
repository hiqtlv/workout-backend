package se.hiq.workout.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SessionController {

  @Autowired
  private SessionService sessionService;


  @GetMapping("/session")
  public List<Session> getSessions() {
    return  sessionService.getAll();
  }

  @GetMapping("/session/{id}")
  public Session getSessionById(@PathVariable Long id) {
    return  sessionService.getById(id);
  }

   @PostMapping("/session")
  public Session createSession(@RequestBody Session session) {
    return sessionService.createSession(session);
   }
}
