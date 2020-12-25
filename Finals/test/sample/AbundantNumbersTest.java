package sample;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class AbundantNumbersTest implements NumbersCheckTest{
  private static Stream<Arguments> testSamples() {

    return Stream.of(
            Arguments.of(12, true),
            Arguments.of(18, true),
            Arguments.of(20, true),
            Arguments.of(24, true),
            Arguments.of(34, false),
            Arguments.of(1, false),
            Arguments.of(3, false)

    );
  }

  @Override
  public boolean processor(Integer input){return NumbersCheck.checkIfNumberIsAbundant(input);}


}
