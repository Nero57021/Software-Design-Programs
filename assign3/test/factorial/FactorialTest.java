package factorial;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

public interface FactorialTest {
  @Test
  default void canary() {
    assertTrue(true);
  }

  BigInteger factorial(int number);

  @Test
  default void testCases() {
    assertAll(
      () -> assertEquals(new BigInteger("1"), factorial(0)),
      () -> assertEquals(new BigInteger("1"), factorial(1)),
      () -> assertEquals(new BigInteger("2"), factorial(2)),
      () -> assertEquals(new BigInteger("6"), factorial(3)),
      () -> assertEquals(new BigInteger("24"), factorial(4)),
      () -> assertEquals(new BigInteger("120"), factorial(5)),
      () -> assertEquals(new BigInteger("3628800"), factorial(10)),
      () -> assertEquals(new BigInteger("30414093201713378043612608166064768844377641568960512000000000000"), factorial(50))
    );
  }
}
