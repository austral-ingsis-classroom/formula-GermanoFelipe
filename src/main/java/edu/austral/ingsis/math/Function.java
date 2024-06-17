package edu.austral.ingsis.math;

import edu.austral.ingsis.math.Visitor.Visitor;

public interface Function {
  public <E> E accept(Visitor<E> visitor);
}
