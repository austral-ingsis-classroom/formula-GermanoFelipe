package edu.austral.ingsis.math;

import edu.austral.ingsis.math.Visitor.Visitor;

public class Variable implements Function{

  private final String name;

  public Variable(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public <E> E accept(Visitor<E> visitor) {
    return visitor.visitVariable(this);
  }
}
