package processor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public interface BlockProcessorTest {
  @Test
  default void canary() {
    assertTrue(true);
  }

  @ParameterizedTest
  @MethodSource("testSamples")
  default void convert(String input, String expectedValue) {
    assertEquals(expectedValue, processor(input));
  }

  String processor(String input);
}
