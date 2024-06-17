package edu.austral.ingsis.math;

import edu.austral.ingsis.math.Visitor.Visitor;

public class Multiplication implements Function{

  private final Function function1;
  private final Function function2;

  public Multiplication(Function function1, Function function2) {
    this.function1 = function1;
    this.function2 = function2;
  }

  public Function getFunction1() {
    return function1;
  }

  public Function getFunction2() {
    return function2;
  }

  @Override
  public <E> E accept(Visitor<E> visitor) {
    return visitor.visitMultiplication(this);
  }
}
