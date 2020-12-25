package processor;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public interface BlockAccessor {

  @SuppressWarnings("unchecked")
  static <T> T invokeMethod(Method method, String input) {
    try {
      return (T) method.invoke(null, input);
    } catch (Exception ex) {
      throw new RuntimeException(ex.getMessage());
    }
  }

  static <T> Function<String, T> getAMethod(String namespace, String methodInput) throws Exception {
    var className = Class.forName(namespace);

    Method method = className.getMethod(methodInput, String.class);

    return input -> invokeMethod(method, input);

  }

  @SuppressWarnings("unchecked")
  static Function<String, String> getAMethod(String namespace, String methodInput, String blocker) throws Exception {
    return (Function<String, String>) getAMethod(namespace, methodInput).apply(blocker);
  }

  static Function<String, String> getBlock(String input) throws Exception {
    List<String> splitBlockInput = Arrays.asList(input.split(":"));

    if (splitBlockInput.get(1).equals("createBlocker")) {
      return getAMethod(splitBlockInput.get(0),splitBlockInput.get(1), splitBlockInput.get(2));
    } else {
      return getAMethod(splitBlockInput.get(0),splitBlockInput.get(1));
    }
  }
}
