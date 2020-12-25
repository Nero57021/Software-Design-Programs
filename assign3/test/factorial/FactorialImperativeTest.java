package factorial;

import java.math.BigInteger;

public class FactorialImperativeTest implements FactorialTest {
  @Override
  public BigInteger factorial(int number) {
    return Factorial.imperativeFactorial(number);
  }
}
