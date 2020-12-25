package processor;

import java.util.function.Function;

public interface BlockProcessor {
  static String upperCase(String input) {
    return input.toUpperCase();
  }

  static String lowerCase(String input) {
    return input.toLowerCase();
  }

  static String multiplier(String input) {
    return input.repeat(2);
  }

  static Function<String, String> createBlocker(String characterToBlock) {
    return input -> input.replace(characterToBlock, "");
  }
}
