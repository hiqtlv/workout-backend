package se.hiq.workout.session;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(MockitoJUnitRunner.class)
public class SessionServiceTest {


  @Mock
  private SessionRepository sessionRepository;

  @InjectMocks
  private SessionService sessionService = new SessionService();


  @Test
  public void getSessionsTest() {

    sessionService.getAll();

    verify(sessionRepository, times(1)).findAll();
; }

  @Test
  public void getSessionByIdTest() {

    sessionService.getById(2L);

    verify(sessionRepository, times(1)).findById(2L);
  }

  @Test
  public void deleteSessionByIdTest() {

    sessionRepository.deleteById(45L);

    verify(sessionRepository, times(1)).deleteById(45L);
  }
}
