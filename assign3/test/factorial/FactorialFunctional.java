package factorial;

import java.math.BigInteger;

public class FactorialFunctional implements FactorialTest {
  @Override
  public BigInteger factorial(int number) {
    return Factorial.functionalFactorial(number);
  }
}
