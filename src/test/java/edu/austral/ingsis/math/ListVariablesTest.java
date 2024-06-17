package edu.austral.ingsis.math;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import edu.austral.ingsis.math.Visitor.VariableVisitor;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ListVariablesTest {

  final VariableVisitor listVisitor = new VariableVisitor();

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    final Addition add = new Addition(new Value(1), new Value(6));
    final List<String> result = listVisitor.visitAddition(add);

    assertThat(result, empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    final Division div = new Division(new Value(12), new Variable("div"));
    final List<String> result = listVisitor.visitDivision(div);
    assertThat(result, containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    final Division div = new Division(new Value(9), new Variable("x"));
    final Multiplication multiplication = new Multiplication(div, new Variable("y"));
    final List<String> result = listVisitor.visitMultiplication(multiplication);

    assertThat(result, containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    final Division div = new Division(new Value(27), new Variable("a"));
    final Power power = new Power(div, new Variable("b"));
    final List<String> result = listVisitor.visitPower(power);

    assertThat(result, containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    final Power power = new Power(new Variable("z"), new Division(new Value(1), new Value(2)));

    final List<String> result = listVisitor.visitPower(power);

    assertThat(result, containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    final Absolut absolute = new Absolut(new Variable("value"));
    final Subtract subtract = new Subtract(absolute, new Value(8));
    final List<String> result = listVisitor.visitSubtract(subtract);

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction7() {
    final Absolut absolute = new Absolut(new Variable("value"));
    final Subtract subtract = new Subtract(absolute, new Value(8));

    final List<String> result = listVisitor.visitSubtract(subtract);

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    final Subtract subtract = new Subtract(new Value(5), new Variable("i"));
    final Multiplication multiplication = new Multiplication(subtract, new Value(8));
    final List<String> result = listVisitor.visitSubtract(subtract);

    assertThat(result, containsInAnyOrder("i"));
  }

  @Test
  public void shouldListVariablesFUnction9(){
    final SquareRoot squareRoot = new SquareRoot(new Value(25));
    final List<String> result = listVisitor.visitSquareRoot(squareRoot);

    assertThat(result, empty());
  }
}
