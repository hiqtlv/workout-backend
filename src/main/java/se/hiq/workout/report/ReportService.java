package se.hiq.workout.report;

import org.springframework.beans.factory.annotation.Autowired;
import se.hiq.workout.session.SessionRepository;

import java.time.LocalDateTime;
import java.util.List;

public class ReportService {

  @Autowired
  private SessionRepository sessionRepository;

  List<SessionReport> getByStartAndEndDate(LocalDateTime startDate, LocalDateTime endDate) {

    return sessionRepository.findSumByStartAndEndDate(startDate, endDate);

  }

  List<SessionReport> getByType(String type) {
    return sessionRepository.findSumByType(type);
  }
}
