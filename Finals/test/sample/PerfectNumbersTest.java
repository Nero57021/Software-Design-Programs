package sample;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class PerfectNumbersTest implements NumbersCheckTest{
  private static Stream<Arguments> testSamples() {

    return Stream.of(
            Arguments.of(6, true),
            Arguments.of(20, false),
            Arguments.of(1, false),
            Arguments.of(7, false)
    );
  }

  @Override
  public boolean processor(Integer input){return NumbersCheck.perfectNumberCheck(input);}

}
