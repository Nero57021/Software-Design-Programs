package factorial;

import java.math.BigInteger;
import java.util.stream.IntStream;

public interface Factorial {
  static BigInteger imperativeFactorial(int number) {
    BigInteger product = BigInteger.ONE;

    for (int i = 1; i <= number; i++) {
      product = product.multiply(new BigInteger(String.valueOf(i)));
    }

    return product;
  }

  static BigInteger recursiveFactorial(int number) {
    return (number == 0) ? BigInteger.ONE : BigInteger.valueOf(number).multiply(recursiveFactorial(number - 1));
  }

  static BigInteger functionalFactorial(int number) {
    return IntStream.rangeClosed(1, number)
      .mapToObj(BigInteger::valueOf)
      .reduce(BigInteger.ONE, BigInteger::multiply);
  }
}
