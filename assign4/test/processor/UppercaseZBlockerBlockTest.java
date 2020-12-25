package processor;

import org.junit.jupiter.params.provider.Arguments;

import java.util.function.Function;
import java.util.stream.Stream;

public class UppercaseZBlockerBlockTest implements BlockProcessorTest {
  Function<String, String> ZBlocker = BlockProcessor.createBlocker("Z");

  private static Stream<Arguments> testSamples() {
    return Stream.of(
      Arguments.of("Z", ""),
      Arguments.of("aZ", "a"),
      Arguments.of("1", "1"),
      Arguments.of("~", "~"),
      Arguments.of("", "")
    );
  }

  @Override
  public String processor(String input) {return ZBlocker.apply(input);}
}
