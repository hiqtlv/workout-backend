package se.hiq.workout.session;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SessionService {

  @Autowired
  private SessionRepository sessionRepository;


  public List<Session> getAll() {
    final List<Session> sessions = new ArrayList<>();
    sessionRepository.findAll().forEach(s -> sessions.add(s));
    return sessions;
   }

  public Session getById(Long id) {
    Optional<Session> byId = sessionRepository.findById(id);
    return byId.orElse(null);
  }

  public Session createSession(Session session) {
    return sessionRepository.save(session);
  }
}
