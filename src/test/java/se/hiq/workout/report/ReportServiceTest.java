package se.hiq.workout.report;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import se.hiq.workout.session.SessionRepository;

import java.time.LocalDateTime;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ReportServiceTest {

  @Mock
  private SessionRepository sessionRepository;


  @InjectMocks
  private  ReportService reportService = new ReportService();

  @Test
  public void getByStartAndEndDate() {

    reportService.getByStartAndEndDate(LocalDateTime.parse("2010-01-01T00:00"), LocalDateTime.parse("2010-01-02T00:00"));

    verify(sessionRepository, times(1)).findSumByStartAndEndDate(LocalDateTime.parse("2010-01-01T00:00"), LocalDateTime.parse("2010-01-02T00:00"));

  }

  @Test
  public void getByType() {

    reportService.getByType("running");

    verify(sessionRepository, times(1)).findSumByType("running");

  }
}
