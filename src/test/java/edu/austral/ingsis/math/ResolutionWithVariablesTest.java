package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.Visitor.CalculateWithVariableVisitor;
import edu.austral.ingsis.math.Visitor.VariableVisitor;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class ResolutionWithVariablesTest {

  final CalculateWithVariableVisitor calculateWithVariableVisitor =
      new CalculateWithVariableVisitor(
          Map.of(
              "x", new Value(3.0),
              "div", new Value(4.0),
              "y", new Value(4.0),
              "a", new Value(9.0),
              "b", new Value(3.0),
              "z", new Value(36.0),
              "value", new Value(8.0),
              "i", new Value(2.0)));

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    final Addition addition = new Addition(new Value(1), new Variable("x"));
    final Double result = calculateWithVariableVisitor.visitAddition(addition);

    assertThat(result, equalTo(4.0));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    final Division division = new Division(new Value(12), new Variable("div"));
    final Double result = calculateWithVariableVisitor.visitDivision(division);

    assertThat(result, equalTo(3.0));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    final Multiplication multiplication =
        new Multiplication(
            new Division(new Value(9), new Variable("x")), new Variable("y"));
    final Double result = calculateWithVariableVisitor.visitMultiplication(multiplication);

    assertThat(result, equalTo(12.0));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    final Power power =
        new Power(
            new Division(new Value(27), new Variable("a")), new Variable("b"));
    final Double result = calculateWithVariableVisitor.visitPower(power);

    assertThat(result, equalTo(27.0));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    final SquareRoot squareRoot = new SquareRoot(new Variable("z"));
    final Double result = calculateWithVariableVisitor.visitSquareRoot(squareRoot);

    assertThat(result, equalTo(6.0));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    final Absolut absolut = new Absolut(new Variable("value"));
    final Subtract subtract = new Subtract(absolut, new Value(8));
    final Double result = calculateWithVariableVisitor.visitSubtract(subtract);

    assertThat(result, equalTo(0.0));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction7() {
    final Absolut absolut = new Absolut(new Variable("value"));
    final Subtract subtract = new Subtract(absolut, new Value(8));
    final Double result = calculateWithVariableVisitor.visitSubtract(subtract);

    assertThat(result, equalTo(0.0));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {
    final Subtract subtract = new Subtract(new Value(5), new Variable("i"));
    final Multiplication multiplication = new Multiplication(subtract, new Value(8));
    final Double result = calculateWithVariableVisitor.visitMultiplication(multiplication);

    assertThat(result, equalTo(24.0));
  }

  @Test
  public void shouldReturnIllegalArg() {
    final VariableVisitor variableVisitor = new VariableVisitor();
    final Variable variable = new Variable("notFound");
    try {
      variable.accept(variableVisitor);
    } catch (IllegalArgumentException error) {
      assertThat(error.getMessage(), equalTo("Variable" + variable + "not found"));
    }
  }
}
