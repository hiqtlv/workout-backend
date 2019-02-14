package se.hiq.workout.report;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import se.hiq.workout.report.SessionReport;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SessionReportControllerTest {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void getReportByStartAndEndDateTest() {
    System.out.println(LocalDateTime.parse("2021-02-04T00:00").toString());

    ResponseEntity<SessionReport[]> sessionReportResponse = restTemplate.getForEntity("/report?startDate=2021-02-04T00:00&endDate=2021-02-08T00:00", SessionReport[].class);

    assertEquals(200, sessionReportResponse.getStatusCode().value());
    SessionReport[] sessionReports = sessionReportResponse.getBody();
    assertNotNull(sessionReports);
    assertEquals(2, sessionReports.length);

  }


  @Test
  public void getReportByTypeTest() {

    ResponseEntity<SessionReport[]> sessionReportResponse = restTemplate.getForEntity("/report?type=running", SessionReport[].class);

    assertEquals(200, sessionReportResponse.getStatusCode().value());
    SessionReport[] sessionReports = sessionReportResponse.getBody();
    assertNotNull(sessionReports);
    assertEquals(3, sessionReports.length);

  }

}
