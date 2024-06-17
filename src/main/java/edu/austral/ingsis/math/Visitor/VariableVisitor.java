package edu.austral.ingsis.math.Visitor;

import edu.austral.ingsis.math.*;
import java.util.ArrayList;
import java.util.List;

public class VariableVisitor implements Visitor<List<String>> {

  private final List<String> variables = new ArrayList<>();

  @Override
  public List<String> visitValue(Value value) {
    return variables;
  }

  @Override
  public List<String> visitVariable(Variable variable) {
    variables.add(variable.getName());
    return variables;
  }

  @Override
  public List<String> visitAddition(Addition addition) {
    addition.getFunction1().accept(this);
    addition.getFunction2().accept(this);
    return variables;
  }

  @Override
  public List<String> visitSubtract(Subtract subtract) {
    subtract.getFunction1().accept(this);
    subtract.getFunction2().accept(this);
    return variables;
  }

  @Override
  public List<String> visitMultiplication(Multiplication multiplication) {
    multiplication.getFunction1().accept(this);
    multiplication.getFunction2().accept(this);
    return variables;
  }

  @Override
  public List<String> visitDivision(Division division) {
    division.getFunction1().accept(this);
    division.getFunction2().accept(this);
    return variables;
  }

  @Override
  public List<String> visitSquareRoot(SquareRoot squareRoot) {
    squareRoot.getFunction().accept(this);
    return variables;
  }

  @Override
  public List<String> visitPower(Power power) {
    power.getFunction1().accept(this);
    power.getFunction2().accept(this);
    return variables;
  }

  @Override
  public List<String> visitAbsolut(Absolut absolut) {
    absolut.getFunction().accept(this);
    return variables;
  }
}
