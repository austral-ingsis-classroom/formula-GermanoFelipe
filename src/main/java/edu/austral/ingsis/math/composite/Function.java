package edu.austral.ingsis.math.composite;

import java.util.List;
import java.util.Map;

public interface Function {
  String print();
  double evaluate(Map<String, Function> variables);
  List<String> listVariables();
}
