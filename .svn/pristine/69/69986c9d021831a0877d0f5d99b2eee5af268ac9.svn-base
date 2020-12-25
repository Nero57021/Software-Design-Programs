package processor;

import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;

public class MultiplierTest implements BlockProcessorTest {

  private static Stream<Arguments> testSamples() {

    return Stream.of(
      Arguments.of("a", "aa"),
      Arguments.of("A", "AA"),
      Arguments.of("1", "11"),
      Arguments.of("~", "~~"),
      Arguments.of("", "")
    );
  }

  @Override
  public String processor(String input) {return BlockProcessor.multiplier(input);}

}
