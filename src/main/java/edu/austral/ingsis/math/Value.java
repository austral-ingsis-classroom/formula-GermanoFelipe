package edu.austral.ingsis.math;

import edu.austral.ingsis.math.Visitor.Visitor;

public class Value implements Function {

  private final double value;

  public Value(double value) {
    this.value = value;
  }

  public double getValue() {
    return value;
  }

  @Override
  public <E> E accept(Visitor<E> visitor) {
    return visitor.visitValue(this);
  }
}
