import java.util.*;
import java.util.function.*;
import java.lang.reflect.*;

interface Util {
  static String greet(String name) { return "hello " + name; }
  
  static Function<String, String> greetMessage(String message) {
    return name -> message + " " + name;
  }
}

public class Sample {  
  public static <T> T invokeMethod(Method method, String input) {
    try {
      return (T) method.invoke(null, input);
    } catch(Exception ex) {
      throw new RuntimeException(ex.getMessage());
    }
  }
  
  public static <T> Function<String, T> getAMethod(String namespace, String methodName) throws Exception {
    var klass = Class.forName(namespace);
    Method method = klass.getMethod(methodName, String.class);
    
    return input -> invokeMethod(method, input);
  }

  public static Function<String, String> getAMethod(String namespace, String methodName, String arg) throws Exception {
    return (Function<String, String>) getAMethod(namespace, methodName).apply(arg);
  }
  
  public static void main(String[] args) throws Exception {
    Function<String, String> method1 = getAMethod("Util", "greet");
    System.out.println(method1.apply("World"));
    
    Function<String, String> method2 = getAMethod("Util", "greetMessage", "howdy");
    System.out.println(method2.apply("World"));
    
    List<Function<String, String>> functions = List.of(
      getAMethod("Util", "greet"),
      getAMethod("Util", "greetMessage", "hi")
    );
    
    System.out.println("--------------");
    
    functions.stream()
      .map(function -> function.apply("universe"))
      .forEach(System.out::println);
  }
}
