package processor;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface Processor {
  @SafeVarargs
  static String processInput(String input, Function<String, String>... blocks) {
    Function<String, String> combinedBlocks = Stream.of(blocks)
      .reduce(Function.identity(), Function::andThen);

    return Stream.of(input.split(""))
      .map(combinedBlocks)
      .collect(Collectors.joining(""));
  }
}
