package se.hiq.workout.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class SessionReportController {

  @Autowired
  private ReportService reportService;


  @GetMapping(value = "/report", params = {"startDate", "endDate"})
  public List<SessionReport> getByStartAndEndDate(
          @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
          @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
    return reportService.getByStartAndEndDate(startDate, endDate);
  }

  @GetMapping(value = "/report", params = "type")
  public List<SessionReport> getByType(@RequestParam String type) {
    return reportService.getByType(type);
  }
}
