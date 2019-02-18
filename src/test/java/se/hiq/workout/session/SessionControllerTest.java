package se.hiq.workout.session;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.HashMap;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SessionControllerTest {


  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void getWorkoutSessionTest() {

    Session[] sessions = restTemplate.getForObject("/session", Session[].class);

    assertNotNull(sessions);
    Session session1 = sessions[0];
    assertEquals(1, session1.getId());
    assertEquals("running", session1.getType());
    assertEquals(1400, session1.getDuration());
    assertEquals(100, session1.getDistance());
    assertEquals("2010-01-01T00:00", session1.getDate().toString());
  }

  @Test
  public void getWorkoutSessionByIdTest() {

    Session session = restTemplate.getForObject("/session/1000", Session.class);

    assertNotNull(session);
    assertEquals(1000, session.getId());
    assertEquals("running", session.getType());
    assertEquals(1400, session.getDuration());
    assertEquals(100, session.getDistance());
    assertEquals("2021-02-02T00:00", session.getDate().toString());
  }

  @Test
  public void addWorkoutSessionTest() {
    Session session = new Session();
    session.setType("mounting biking");
    session.setDistance(100);
    session.setDuration(1400);
    session.setDate(LocalDateTime.parse("2011-01-01T00:00"));

    ResponseEntity<Session> sessionResponseEntity = restTemplate.postForEntity("/session", session, Session.class, new HashMap<>());

    assertEquals(200, sessionResponseEntity.getStatusCode().value());
    Session responseSession = sessionResponseEntity.getBody();
    assertNotNull(responseSession);
    assertEquals(100, responseSession.getDistance());
    assertNotEquals(0, responseSession.getId());

  }

}
