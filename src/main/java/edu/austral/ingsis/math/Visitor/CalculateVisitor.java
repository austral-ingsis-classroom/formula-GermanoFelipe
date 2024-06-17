package edu.austral.ingsis.math.Visitor;

import edu.austral.ingsis.math.*;

public class CalculateVisitor implements Visitor<Double>{
  @Override
  public Double visitValue(Value value) {
    return value.getValue();
  }

  @Override
  public Double visitVariable(Variable variable) {
    return null;
  }

  @Override
  public Double visitAddition(Addition addition) {
    return addition.getFunction1().accept(this) + addition.getFunction2().accept(this);
  }

  @Override
  public Double visitSubtract(Subtract subtract) {
    return null;
  }

  @Override
  public Double visitMultiplication(Multiplication multiplication) {
    return null;
  }

  @Override
  public Double visitDivision(Division division) {
    return null;
  }

  @Override
  public Double visitSquareRoot(SquareRoot squareRoot) {
    return null;
  }

  @Override
  public Double visitPower(Power power) {
    return null;
  }

  @Override
  public Double visitAbsolut(Absolut absolut) {
    return null;
  }
}
