package processor;

import org.junit.jupiter.params.provider.Arguments;

import java.util.function.Function;
import java.util.stream.Stream;

public class LowercaseKBlockerBlockTest implements BlockProcessorTest {

  Function<String, String> kBlocker = BlockProcessor.createBlocker("k");

  private static Stream<Arguments> testSamples() {
    return Stream.of(
      Arguments.of("k", ""),
      Arguments.of("ak", "a"),
      Arguments.of("1", "1"),
      Arguments.of("~", "~"),
      Arguments.of("", "")
    );
  }

  @Override
  public String processor(String input) {return kBlocker.apply(input);}
}
