package edu.austral.ingsis.math.composite;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Function {
  String print();
  double evaluate(Map<String, Function> variables);
  Set<String> listVariables();
}
