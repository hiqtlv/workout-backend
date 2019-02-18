package se.hiq.workout.report;


public class SessionReport {

  private Long numberOfSessions;
  private Long distance;
  private Long duration;
  private String type;


  public SessionReport(){}

  public SessionReport(Long distance, Long duration, String type, Long numberOfSessions) {
    this.distance = distance;
    this.duration = duration;
    this.type = type;
    this.numberOfSessions = numberOfSessions;
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

  public Long getNumberOfSessions() {
    return numberOfSessions;
  }

  public void setNumberOfSessions(Long numberOfSessions) {
    this.numberOfSessions = numberOfSessions;
  }

  public Long getDuration() {
    return duration;
  }

  public void setDuration(Long duration) {
    this.duration = duration;
  }
}
