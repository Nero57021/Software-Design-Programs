abstract class SampleAbstract {

  public String invoke() {
    return actionOne();
  }

  public abstract String actionOne();
}

class One extends SampleAbstract {

  @Override
  public String actionOne() {
    return "This is one";
  }
}

class Two extends SampleAbstract{

  @Override
  public String actionOne() {
    return "This is two";
  }
}

class Sample {
  public static void main(String[] args) {
    SampleAbstract one = new One();
    SampleAbstract two = new Two();

    System.out.println(one.invoke()); // This is one
    System.out.println(two.invoke()); // This is two
  }
}

// For the same output, let's reduce the duplication.
// How can use use OOP, inheritance, polymorphism to do that?