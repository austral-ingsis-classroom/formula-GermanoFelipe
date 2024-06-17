package edu.austral.ingsis.math.Visitor;

import edu.austral.ingsis.math.*;

public interface Visitor<E>{

  E visitValue(Value value);

  E visitVariable(Variable variable);

  E visitAddition(Addition addition);
}
