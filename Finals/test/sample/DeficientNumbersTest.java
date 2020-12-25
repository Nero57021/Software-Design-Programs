package sample;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class DeficientNumbersTest implements NumbersCheckTest{
  private static Stream<Arguments> testSamples() {

    return Stream.of(
            Arguments.of(1, true),
            Arguments.of(2, true),
            Arguments.of(3, true),
            Arguments.of(21, true),
            Arguments.of(12, false)
    );
  }


  @Override
  public boolean processor(Integer input){return NumbersCheck.checkDeficientNumber(input);}

}
