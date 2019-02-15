package se.hiq.workout.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class SessionController {

  @Autowired
  private SessionService sessionService;


  @GetMapping("/session")
  List<Session> getSessions() {
    return sessionService.getAll();
  }

  @GetMapping("/session/{id}")
  Session getSessionById(@PathVariable Long id) {
    return sessionService.getById(id);
  }

  @PostMapping("/session")
  Session createSession(@RequestBody Session session) {
    return sessionService.createSession(session);
  }
}
