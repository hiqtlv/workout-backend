package se.hiq.workout;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.hiq.workout.report.ReportService;
import se.hiq.workout.session.SessionService;

@Configuration
public class ApplicationConfiguration {

  @Bean
  public SessionService getSessionService() {

    return new SessionService();
  }

  @Bean
  public ReportService getReportService() {

    return new ReportService();
  }
}
