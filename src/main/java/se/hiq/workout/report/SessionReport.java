package se.hiq.workout.report;


import java.time.LocalDateTime;

public class SessionReport {

  private LocalDateTime date;
  private Long distance;
  private Long duration;
  private String type;


  public SessionReport(){}

  public SessionReport(Long distance, Long duration, String type, LocalDateTime date) {
    this.distance = distance;
    this.duration = duration;
    this.type = type;
    this.date = date;
  }

  public void setDistance(Long distance) {
    this.distance = distance;
  }

  public Long getDistance() {
    return distance;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }

  public Long getDuration() {
    return duration;
  }

  public void setDuration(Long duration) {
    this.duration = duration;
  }
}
