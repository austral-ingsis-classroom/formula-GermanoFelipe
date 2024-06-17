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
    return subtract.getFunction1().accept(this) - subtract.getFunction2().accept(this);
  }

  @Override
  public Double visitMultiplication(Multiplication multiplication) {
    return multiplication.getFunction1().accept(this) * multiplication.getFunction2().accept(this);
  }

  @Override
  public Double visitDivision(Division division) {
    return division.getFunction1().accept(this) / division.getFunction2().accept(this);
  }

  @Override
  public Double visitSquareRoot(SquareRoot squareRoot) {
    return Math.sqrt(squareRoot.getFunction().accept(this));
  }

  @Override
  public Double visitPower(Power power) {
    return Math.pow(power.getFunction1().accept(this), power.getFunction2().accept(this));
  }

  @Override
  public Double visitAbsolut(Absolut absolut) {
    return Math.abs(absolut.getFunction().accept(this));
  }
}
