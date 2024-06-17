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
    variables.addAll(addition.getFunction1().accept(this));
    variables.addAll(addition.getFunction2().accept(this));
    return variables;
  }

  @Override
  public List<String> visitSubtract(Subtract subtract) {
    variables.addAll(subtract.getFunction1().accept(this));
    variables.addAll(subtract.getFunction2().accept(this));
    return variables;
  }

  @Override
  public List<String> visitMultiplication(Multiplication multiplication) {
    variables.addAll(multiplication.getFunction1().accept(this));
    variables.addAll(multiplication.getFunction2().accept(this));
    return variables;
  }

  @Override
  public List<String> visitDivision(Division division) {
    variables.addAll(division.getFunction1().accept(this));
    variables.addAll(division.getFunction2().accept(this));
    return variables;
  }

  @Override
  public List<String> visitSquareRoot(SquareRoot squareRoot) {
    variables.addAll(squareRoot.getFunction().accept(this));
    return variables;
  }

  @Override
  public List<String> visitPower(Power power) {
    variables.addAll(power.getFunction1().accept(this));
    variables.addAll(power.getFunction2().accept(this));
    return variables;
  }

  @Override
  public List<String> visitAbsolut(Absolut absolut) {
    variables.addAll(absolut.getFunction().accept(this));
    return variables;
  }
}
