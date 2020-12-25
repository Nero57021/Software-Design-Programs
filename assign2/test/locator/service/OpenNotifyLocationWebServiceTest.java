package locator.service;

import locator.preview.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OpenNotifyLocationWebServiceTest {

  OpenNotifyLocationWebService webService;

  @BeforeEach
  void init() {
    webService = new OpenNotifyLocationWebService();
  }

  @Test
  void getRawResponseTakesURLReturnsPassesLatAndLong() throws IOException, InterruptedException {

    String response = webService.getRawResponse(29.72167, -95.343631);
    System.out.println(response);
    Pattern pattern = Pattern.compile("passes|latitude|longitude");
    assertTrue(pattern.matcher(response).find());
  }

  @Test
  void parseJSONTakesRawJSONReturnsTime() {

    final String VALID_JSON_RESPONSE = """
       {
         "message": "success",
         "request": {
           "altitude": 100,
           "datetime": 1602201251,
           "latitude": 29.72167,
           "longitude": -95.343631,
           "passes": 1
         },
         "response": [
           {
             "duration": 645,
             "risetime": %d
           }
         ]
       }
      """;

    assertAll(
      () -> assertEquals("1602203714", webService.parseJSON(String.format(VALID_JSON_RESPONSE, 1602203714))),
      () -> assertEquals("1602209521", webService.parseJSON(String.format(VALID_JSON_RESPONSE, 1602209521)))
    );
  }

  @Test
  void getFlyOverTimeTakesLocationReturnResponseFromParseJSON() throws Exception {

    webService = spy(OpenNotifyLocationWebService.class);
    doReturn("test").when(webService).getRawResponse(29.72167, -95.343631);
    doReturn("1602209521").when(webService).parseJSON("test");

    assertEquals("02:12AM", webService.getFlyOverTimeForLocation(new Location(29.72167, -95.343631)));
  }

  @Test
  void getFlyOverTimeThrowsExceptionFromGetRawResponse() throws Exception {
    webService = spy(OpenNotifyLocationWebService.class);

    doThrow(new RuntimeException("network error")).when(webService).getRawResponse(100.12, 190.2323);
    assertThrows(RuntimeException.class, () -> webService.getFlyOverTimeForLocation(new Location(100.12, 190.2323)));
  }

  @Test
  void getFlyOverTimeThrowsExceptionFromParseJSON() throws Exception {

    webService = spy(OpenNotifyLocationWebService.class);

    doReturn("test").when(webService).getRawResponse(100.12, 190.2323);
    doThrow(new RuntimeException("invalid location")).when(webService).parseJSON("test");

    assertThrows(RuntimeException.class, () -> webService.getFlyOverTimeForLocation(new Location(100.12, 190.2323)));
  }

  @Test
  void getFlyOverTimeForLocationTestRequestFailure() {
    assertThrows(RuntimeException.class, () -> webService.getFlyOverTimeForLocation(new Location(72.721670, -80.34363)));
  }

  @Test
  void getFlyOverTimeForLocationInvalidLat() {
    assertThrows(RuntimeException.class, () -> webService.getFlyOverTimeForLocation(new Location(129.721670, -95.343631)));
  }

}
