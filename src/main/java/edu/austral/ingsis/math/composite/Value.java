package edu.austral.ingsis.math.composite;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Value implements Function{

  private final double value;

  public Value(double value) {
    this.value = value;
  }

  @Override
  public String print() {
    return this.valueToString();
  }

  @Override
  public double evaluate(Map<String, Function> variables) {
    return value;
  }

  @Override
  public Set<String> listVariables() {
    return Set.of();
  }

  public String valueToString() {
    return String.valueOf(this.value);
  }
}
