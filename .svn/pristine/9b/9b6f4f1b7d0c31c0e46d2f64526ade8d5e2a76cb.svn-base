package processor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProcessorTest {

  @Test
  void givenAStringAndNoBlocksReturnGivenString() {
    assertEquals("abzCd", Processor.processInput("abzCd"));
  }

  @Test
  void givenAStringUppercaseBlockReturnString() {
    assertEquals("ABZCD", Processor.processInput("abzCd", BlockProcessor::upperCase));
  }

  @Test
  void givenAStringLowercaseBlockReturnString() {
    assertEquals("abzcd", Processor.processInput("abzCd", BlockProcessor::lowerCase));
  }

  @Test
  void givenAStringMultiplierBlockReturnString() {
    assertEquals("aabbzzCCdd", Processor.processInput("abzCd", BlockProcessor::multiplier));
  }

  @Test
  void givenAStringUppercaseAndZBlockerBlockReturnString() {
    assertEquals("ABCD", Processor.processInput("abzcd",
      BlockProcessor::upperCase,
      BlockProcessor.createBlocker("Z")));
  }

  @Test
  void givenAStringZBlockerAndUppercaseBlockReturnString() {
    assertEquals("ABZCD", Processor.processInput("abzcd",
      BlockProcessor.createBlocker("Z"),
      BlockProcessor::upperCase));
  }

  @Test
  void givenAStringUppercaseAndMultiplierBlockReturnString() {
    assertEquals("AABBZZCCDD", Processor.processInput("abzcd",
      BlockProcessor::upperCase,
      BlockProcessor::multiplier));
  }

  @Test
  void givenAStringZBlockerUppercaseAndMultiplierBlockReturnString() {
    assertEquals("AABBZZCCDD", Processor.processInput("abzcd",
      BlockProcessor.createBlocker("Z"),
      BlockProcessor::upperCase,
      BlockProcessor::multiplier));
  }

}
