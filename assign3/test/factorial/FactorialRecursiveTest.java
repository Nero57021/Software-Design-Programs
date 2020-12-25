package factorial;

import java.math.BigInteger;

public class FactorialRecursiveTest implements FactorialTest {
  @Override
  public BigInteger factorial(int number) {
    return Factorial.recursiveFactorial(number);
  }
}
