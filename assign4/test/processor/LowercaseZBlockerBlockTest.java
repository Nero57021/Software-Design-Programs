package processor;

import org.junit.jupiter.params.provider.Arguments;

import java.util.function.Function;
import java.util.stream.Stream;

public class LowercaseZBlockerBlockTest implements BlockProcessorTest {
  Function<String, String> zBlocker = BlockProcessor.createBlocker("z");

  private static Stream<Arguments> testSamples() {
    return Stream.of(
      Arguments.of("z", ""),
      Arguments.of("az", "a"),
      Arguments.of("1", "1"),
      Arguments.of("~", "~"),
      Arguments.of("", "")
    );
  }

  @Override
  public String processor(String input) {
    return zBlocker.apply(input);
  }
}
