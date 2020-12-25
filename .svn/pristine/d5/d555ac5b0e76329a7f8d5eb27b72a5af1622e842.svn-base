package ui;

import processor.BlockAccessor;
import processor.Processor;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Function;

public class LogicalProcessorUI {

  @SuppressWarnings("unchecked")
  public static void main(String[] args) {

    String filePath;
    String userCharacterInput;
    String line;

    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter filename for defined processor (ex. processor.txt): ");
    filePath = scanner.nextLine();

    try {
      FileReader fr = new FileReader(filePath);
      Scanner myReader = new Scanner(fr);

      ArrayList<Function<String, String>> listOfBlockFunction = new ArrayList<>();

      System.out.println("These are the block sequence that are going to be used: ");
      while (myReader.hasNextLine()) {
        line = myReader.nextLine();
        System.out.println(line.split(":")[1]);
        listOfBlockFunction.add(BlockAccessor.getBlock(line));
      }

      System.out.println("Enter the string that needs to be processed: ");
      userCharacterInput = scanner.nextLine();

      String output =Processor.processInput(userCharacterInput, listOfBlockFunction.toArray(new Function[0]));
      System.out.println(output);

      myReader.close();
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
  }
  
}
