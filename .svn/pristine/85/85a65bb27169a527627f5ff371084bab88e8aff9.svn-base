package processor;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class CustomBlockerTest implements BlockProcessorTest{

  private static Stream<Arguments> testSamples() {
    return Stream.of(
      Arguments.of("a", "a$"),
      Arguments.of("A", "A$"),
      Arguments.of("1", "1$"),
      Arguments.of("~", "~$"),
      Arguments.of("", "$")
    );
  }

  @Override
  public String processor(String input) {
    return CustomBlocker.addDollar(input);
  }
}
