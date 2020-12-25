package UI;

import java.util.Scanner;
import sample.NumbersCheck;
public class NumberCheckUI {

  public static void main(String[] args){

    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter a number: ");
    int number = scanner.nextInt();

    if(NumbersCheck.perfectNumberCheck(number))
      System.out.println("Given Number is a perfect number");
    else if(NumbersCheck.checkIfNumberIsAbundant(number)) System.out.println("Given Number is Abundant");
    else if(NumbersCheck.checkDeficientNumber(number))
      System.out.println("Given Number is Deficient");
  }
}
