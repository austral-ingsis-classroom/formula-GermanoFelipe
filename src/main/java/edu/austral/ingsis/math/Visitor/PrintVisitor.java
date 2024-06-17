package edu.austral.ingsis.math.Visitor;

import edu.austral.ingsis.math.*;

public class PrintVisitor implements Visitor<String>{
  @Override
  public String visitValue(Value value) {
    return String.valueOf(value.getValue());
  }

  @Override
  public String visitVariable(Variable variable) {
    return variable.getName();
  }

  @Override
  public String visitAddition(Addition addition) {
    return "(" + addition.getFunction1().accept(this) + " + "
            + addition.getFunction2().accept(this) + ")";
  }

  @Override
  public String visitSubtract(Subtract subtract) {
    return "(" + subtract.getFunction1().accept(this) + " - "
            + subtract.getFunction2().accept(this) + ")";
  }

  @Override
  public String visitMultiplication(Multiplication multiplication) {
    return "(" + multiplication.getFunction1().accept(this) + " * "
            + multiplication.getFunction2().accept(this) + ")";
  }

  @Override
  public String visitDivision(Division division) {
    return "(" + division.getFunction1().accept(this) + " / "
            + division.getFunction2().accept(this) + ")";
  }

  @Override
  public String visitSquareRoot(SquareRoot squareRoot) {
    return "sqrt(" + squareRoot.getFunction().accept(this) + ")";
  }

  @Override
  public String visitPower(Power power) {
    return "(" + power.getFunction1().accept(this) + " ^ "
            + power.getFunction2().accept(this) + ")";
  }

  @Override
  public String visitAbsolut(Absolut absolut) {
    return "|" + absolut.getFunction().accept(this) + "|";
  }
}
