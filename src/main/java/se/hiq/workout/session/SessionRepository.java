package se.hiq.workout.session;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import se.hiq.workout.report.SessionReport;

import java.time.LocalDateTime;
import java.util.List;

public interface SessionRepository extends CrudRepository<Session, Long> {

  @Query("Select new se.hiq.workout.report.SessionReport("
          + "SUM(distance) as distance, SUM(duration) as duration, type, MIN(date) as date) "
          + "FROM Session S "
          + "WHERE date>=:startDate and date <=:endDate Group By S.type")
  List<SessionReport> findSumByStartAndEndDate(@Param("startDate") LocalDateTime startDate,
                                               @Param("endDate") LocalDateTime endDate);

  @Query("Select new se.hiq.workout.report.SessionReport("
         + "SUM(distance) as distance, SUM(duration) as duration, type, date) "
         + "FROM Session S "
         + "WHERE S.type=:type Group By S.date")
  List<SessionReport> findSumByType(@Param("type") String type);
}
