package edu.austral.ingsis.math;

import edu.austral.ingsis.math.Visitor.Visitor;

public class SquareRoot implements Function {
  private final Function function1;

  public SquareRoot(Function function1) {
    this.function1 = function1;
  }

  public Function getFunction() {
    return function1;
  }

  @Override
  public <E> E accept(Visitor<E> visitor) {
    return visitor.visitSquareRoot(this);
  }
}
