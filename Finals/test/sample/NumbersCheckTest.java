package sample;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public interface NumbersCheckTest {
  @Test
  default void canary() {
    assertTrue(true);
  }

  @ParameterizedTest
  @MethodSource("testSamples")
  default void convert(Integer input, boolean expectedValue) {
    assertEquals(expectedValue, processor(input));
  }

   boolean processor(Integer input);
}
