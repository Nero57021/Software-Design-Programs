package locator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OpenNotifyAstronautWebServiceTest {

  public OpenNotifyAstronautWebService astronautWebService;

  @BeforeEach
  void init() {
    astronautWebService = new OpenNotifyAstronautWebService();
  }

  @Test
  void getRawResponseReturnJSON() throws IOException, InterruptedException {

    String response = astronautWebService.getRawResponse();
    Pattern pattern = Pattern.compile("number|people|craft|name");
    assertTrue(pattern.matcher(response).find());
  }

  @Test
  void parseJSONAndGetAstronautNames() {
    final String VALID_RESPONSE = """
        {
          "number": 3,
          "people": [
            {
            "craft": "ISS",
            "name": "Chris Cassidy"
          },
          {
            "craft": "ISS",
            "name": "Anatoly Ivanishin"
          },
          {
            "craft": "ISS",
            "name": "Ivan Vagner"
          }
          ],
          "message": "success"
        }
      """;

    assertEquals(List.of("Chris Cassidy", "Anatoly Ivanishin", "Ivan Vagner"), astronautWebService.parseJSON(VALID_RESPONSE));
  }

  @Test
  void parseJSONWithFourAstronauts() {
    final String VALID_RESPONSE = """
        {
          "number": 4,
          "people": [
            {
            "craft": "ISS",
            "name": "Neil Armstrong"
          },
          {
            "craft": "ISS",
            "name": "Buzz Aldrin"
          },
          {
            "craft": "ISS",
            "name": "Sally Ride"
          },
          {
             "craft": "ISS",
             "name": "Yuri Gagarin"
          }
          ],
          "message": "success"
        }
      """;

    assertEquals(List.of("Neil Armstrong", "Buzz Aldrin", "Sally Ride", "Yuri Gagarin"), astronautWebService.parseJSON(VALID_RESPONSE));
  }

  @Test
  void parseJSONWithOneAstronauts() {
    final String VALID_RESPONSE = """
        {
          "number": 1,
          "people": [
            {
            "craft": "ISS",
            "name": "Chris Cassidy"
          }
          ],
          "message": "success"
        }
      """;

    assertEquals(List.of("Chris Cassidy"), astronautWebService.parseJSON(VALID_RESPONSE));
  }

  @Test
  void getAstronautNamesReturnsListOfNames() throws IOException, InterruptedException {

    astronautWebService = spy(OpenNotifyAstronautWebService.class);
    doReturn("test").when(astronautWebService).getRawResponse();
    doReturn(List.of("John Glenn", "Alan Shepard")).when(astronautWebService).parseJSON("test");

    assertEquals(List.of("John Glenn", "Alan Shepard"), astronautWebService.getAstronautNames());
  }

  @Test
  void getAstronautNamesThrowsException() throws IOException, InterruptedException {
    astronautWebService = spy(OpenNotifyAstronautWebService.class);
    doThrow(new RuntimeException("test")).when(astronautWebService).getRawResponse();

    assertThrows(RuntimeException.class, () -> astronautWebService.getAstronautNames());
  }
}
