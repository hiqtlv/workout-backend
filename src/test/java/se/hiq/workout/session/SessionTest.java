package se.hiq.workout.session;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SessionTest {

  @Mock
  private SessionService sessionService;

  @InjectMocks
  private SessionController sessionController;

  @Test
  public void getAllTest() {

    sessionController.getSessions();

    verify(sessionService, times(1)).getAll();
   }

  @Test
  public void getByIdTest() {

    sessionController.getSessionById(4L);

    verify(sessionService, times(1)).getById(4L);
  }

  @Test
  public void createSession() {
    Session session = new Session();

    sessionController.createSession(session);

    verify(sessionService, times(1)).createSession(session);
  }
}
