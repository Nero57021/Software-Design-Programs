package processor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BlockAccessorTest {

    @Test
  void givenAnStringGetBlockReturnsUpperCaseFunction() throws Exception {
    assertEquals("A", BlockAccessor.getBlock("processor.BlockProcessor:upperCase").apply("a"));
  }

  @Test
  void givenAnStringGetBlockReturnsMultiplierFunction() throws Exception {
    assertEquals("aa", BlockAccessor.getBlock("processor.BlockProcessor:multiplier").apply("a"));
  }

  @Test
  void givenAnStringGetBlockReturnsUpperCaseZBlockerFunction() throws Exception {
    assertEquals("a", BlockAccessor.getBlock("processor.BlockProcessor:createBlocker:Z").apply("aZ"));
  }

  @Test
  void givenAnStringGetBlockReturnsLowerCaseZBlockerFunction() throws Exception {
    assertEquals("a", BlockAccessor.getBlock("processor.BlockProcessor:createBlocker:k").apply("ak"));
  }

  @Test
  void customBlockerGivenAnStringGetBlockReturnsAddDollarBlockerFunction() throws Exception {
    assertEquals("a$", BlockAccessor.getBlock("processor.CustomBlocker:addDollar").apply("a"));
  }

  @Test
  void invokeMethodReturnsRuntimeException(){
      assertThrows(RuntimeException.class, () -> BlockAccessor.invokeMethod(null, "a"));
  }

}
