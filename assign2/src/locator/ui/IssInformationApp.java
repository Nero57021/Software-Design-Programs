package locator.ui;

import locator.IssInformation;
import locator.preview.Location;
import locator.service.IssInformationService;
import locator.service.OpenNotifyAstronautWebService;
import locator.service.OpenNotifyLocationWebService;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class IssInformationApp {

  static void printAstronautNames(OpenNotifyAstronautWebService astronautWebService) {

    try {
      System.out.println("\n");
      List<String> astronautsNames = astronautWebService.getAstronautNames();

      System.out.println("There are " + astronautsNames.size() + " on ISS at this time:");
      astronautsNames.forEach(System.out::println);
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
  }

  public static void main(String[] args) {

    IssInformation issInformation = new IssInformation();
    OpenNotifyAstronautWebService openNotifyAstronautWebService = new OpenNotifyAstronautWebService();
    IssInformationService openNotifyLocationWebService = new OpenNotifyLocationWebService();
    issInformation.setIssInformationService(openNotifyLocationWebService);

    List<Location> fileLocations = new ArrayList<>();

    try {
      FileReader fr = new FileReader(args.length > 0 ? args[0] : "locations.txt");

      Scanner scanner = new Scanner(fr);
      while (scanner.hasNextLine()) {
        String[] lineArray = scanner.nextLine().split(",");
        fileLocations.add(new Location(Double.parseDouble(lineArray[0]), Double.parseDouble(lineArray[1])));
      }

      Map<Location, String> locationTime = issInformation.getFlyOverTimeForLocations(fileLocations);


      locationTime.forEach((key, value) -> System.out.println(key.lat() + ", " + key.lon() + ": " + value));

      printAstronautNames(openNotifyAstronautWebService);


    } catch (Exception ex) {
      System.out.println("Service unavailable");
    }

  }
}
