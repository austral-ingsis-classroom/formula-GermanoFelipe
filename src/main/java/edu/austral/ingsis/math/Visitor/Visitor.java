package edu.austral.ingsis.math.Visitor;

import edu.austral.ingsis.math.*;

public interface Visitor<E>{

  E visitValue(Value value);

  E visitVariable(Variable variable);

  E visitAddition(Addition addition);

  E visitSubtract(Subtract subtract);

  E visitMultiplication(Multiplication multiplication);

  E visitDivision(Division division);

  E visitSquareRoot(SquareRoot squareRoot);

  E visitPower(Power power);

  E visitAbsolut(Absolut absolut);
}
