package locator;

import locator.preview.Location;
import locator.service.OpenNotifyLocationWebService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IssInformationTest {

  IssInformation issInformation;
  OpenNotifyLocationWebService issInformationServiceMock;

  @BeforeEach
  void init() {
    issInformation = new IssInformation();
    issInformationServiceMock = mock(OpenNotifyLocationWebService.class);
    issInformation.setIssInformationService(issInformationServiceMock);
  }

  @Test
  void canary() {
    assert (true);
  }

  @Test
  void givenEmptyListOfLocationReturnEmptyList() {
    assertEquals(Map.of(), issInformation.getFlyOverTimeForLocations(List.of()));
  }

  @Test
  void givenListOfLocationsReturnAListOfTime() {
    when(issInformationServiceMock.getFlyOverTimeForLocation(new Location(29.7604, -95.3698))).thenReturn("11:58PM");

    assertEquals(Map.of(new Location(29.7604, -95.3698), "11:58PM"),
      issInformation.getFlyOverTimeForLocations(List.of(new Location(29.7604, -95.3698))));
  }

  @Test
  void givenTwoLocationReturnTimeForBothLocation() {
    when(issInformationServiceMock.getFlyOverTimeForLocation(new Location(29.7604, -95.3698))).thenReturn("11:58PM");
    when(issInformationServiceMock.getFlyOverTimeForLocation(new Location(30.2672, -97.7431))).thenReturn("10:58AM");

    assertEquals(Map.of(
      new Location(29.7604, -95.3698), "11:58PM",
      new Location(30.2672, -97.7431), "10:58AM"),
      issInformation.getFlyOverTimeForLocations(List.of(
        new Location(29.7604, -95.3698),
        new Location(30.2672, -97.7431)
      )));
  }

  @Test
  void givenThreeLocationReturnTimeForThreeLocation() {
    when(issInformationServiceMock.getFlyOverTimeForLocation(new Location(29.7604, -95.3698))).thenReturn("11:58PM");
    when(issInformationServiceMock.getFlyOverTimeForLocation(new Location(30.2672, -97.7431))).thenReturn("10:58AM");
    when(issInformationServiceMock.getFlyOverTimeForLocation(new Location(35.2220, -101.831))).thenReturn("8:30AM");

    assertEquals(Map.of(
      new Location(29.7604, -95.3698), "11:58PM",
      new Location(30.2672, -97.7431), "10:58AM",
      new Location(35.2220, -101.831), "8:30AM"),
      issInformation.getFlyOverTimeForLocations(List.of(
        new Location(29.7604, -95.3698),
        new Location(30.2672, -97.7431),
        new Location(35.2220, -101.831)
      )));
  }

  @Test
  void givenThreeLocationReturnsTimeForTwoLocationAndErrorForLocation() {
    when(issInformationServiceMock.getFlyOverTimeForLocation(new Location(29.7604, -95.3698))).thenReturn("11:58PM");
    when(issInformationServiceMock.getFlyOverTimeForLocation(new Location(100.12, 190.2323))).thenThrow(new RuntimeException("invalid location"));
    when(issInformationServiceMock.getFlyOverTimeForLocation(new Location(35.2220, -101.831))).thenReturn("8:30AM");

    assertEquals(Map.of(
      new Location(29.7604, -95.3698), "11:58PM",
      new Location(100.12, 190.2323), "invalid location",
      new Location(35.2220, -101.831), "8:30AM"
      ),
      issInformation.getFlyOverTimeForLocations(List.of(
        new Location(29.7604, -95.3698),
        new Location(100.12, 190.2323),
        new Location(35.2220, -101.831)
      )));
  }

  @Test
  void givenListOfLocationReturnsTimeForFirstTwoLocationThirdLocationFails() {
    when(issInformationServiceMock.getFlyOverTimeForLocation(new Location(29.7604, -95.3698))).thenReturn("11:58PM");
    when(issInformationServiceMock.getFlyOverTimeForLocation(new Location(30.2672, -97.7431))).thenReturn("2:31PM");
    when(issInformationServiceMock.getFlyOverTimeForLocation(new Location(35.2220, -101.831))).thenThrow(new RuntimeException("network error"));

    assertEquals(Map.of(
      new Location(29.7604, -95.3698), "11:58PM",
      new Location(30.2672, -97.7431), "2:31PM",
      new Location(35.2220, -101.831), "network error"),
      issInformation.getFlyOverTimeForLocations(List.of(
        new Location(29.7604, -95.3698),
        new Location(30.2672, -97.7431),
        new Location(35.2220, -101.831)
      )));
  }

}
