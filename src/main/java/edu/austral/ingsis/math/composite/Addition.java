package edu.austral.ingsis.math.composite;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Addition implements Function{

  private final Function function1;
  private final Function function2;

  public Addition(Function function1, Function function2) {
    this.function1 = function1;
    this.function2 = function2;
  }

  @Override
  public String print() {
    return "(" + function1.print() + " + " + function2.print() + ")";
  }

  @Override
  public double evaluate(Map<String, Function> variables) {
    return function1.evaluate(variables) + function2.evaluate(variables);
  }

  @Override
  public Set<String> listVariables() {
    Set<String> variables1 = function1.listVariables();
    Set<String> variables2 = function2.listVariables();
    return new HashSet<>(variables1){
      {
        addAll(variables2);
      }
    };
  }
}
