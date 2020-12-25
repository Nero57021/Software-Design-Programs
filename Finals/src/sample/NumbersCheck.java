package sample;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public interface NumbersCheck {
  static boolean perfectNumberCheck(int number){
            long sum = LongStream.rangeClosed(1, (number) / 2).filter(i -> number % i == 0).sum();
    return sum == number;

  }

  static boolean checkIfNumberIsAbundant(int number){
    int sum = IntStream.range(1,number).filter(nums->number%nums==0).sum();

    return sum > number;

  }
  static boolean checkDeficientNumber(int number){
    int sum = IntStream.range(1,number).filter(nums->number%nums==0).sum();
    return sum < number;

  }
}
