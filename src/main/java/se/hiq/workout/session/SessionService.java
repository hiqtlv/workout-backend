package se.hiq.workout.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
class SessionService {

  @Autowired
  private SessionRepository sessionRepository;

  List<Session> getAll() {
    final List<Session> sessions = new ArrayList<>();
    sessionRepository.findAll().forEach(s -> sessions.add(s));
    return sessions;
  }

  Session getById(Long id) {
    Optional<Session> byId = sessionRepository.findById(id);
    return byId.orElse(null);
  }

  Session createSession(Session session) {
    return sessionRepository.save(session);
  }
}
