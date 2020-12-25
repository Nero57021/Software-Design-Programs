package processor;

import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;

public class LowerCaseTest implements BlockProcessorTest {
  private static Stream<Arguments> testSamples() {
    return Stream.of(
      Arguments.of("a", "a"),
      Arguments.of("A", "a"),
      Arguments.of("1", "1"),
      Arguments.of("~", "~"),
      Arguments.of("", "")
    );
  }

  @Override
  public String processor(String input) {
    return BlockProcessor.lowerCase(input);
  }
}
