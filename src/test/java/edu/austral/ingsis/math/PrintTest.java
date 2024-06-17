package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.Visitor.PrintVisitor;
import org.junit.jupiter.api.Test;

public class PrintTest {

  final PrintVisitor printVisitor = new PrintVisitor();

  /** Case 1 + 6 */
  @Test
  public void shouldPrintFunction1() {
    final String expected = "(1.0 + 6.0)";
    Addition addition = new Addition(new Value(1), new Value(6));
    final String result = printVisitor.visitAddition(addition);

    assertThat(result, equalTo(expected));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldPrintFunction2() {
    final String expected = "(12.0 / 2.0)";
    Function function = new Division(new Value(12), new Value(2));
    final String result = printVisitor.visitDivision((Division) function);

    assertThat(result, equalTo(expected));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldPrintFunction3() {
    final String expected = "((9.0 / 2.0) * 3.0)";
    Function function = new Multiplication(new Division(new Value(9), new Value(2)), new Value(3));
    final String result = printVisitor.visitMultiplication((Multiplication) function);

    assertThat(result, equalTo(expected));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldPrintFunction4() {
    final String expected = "((27.0 / 6.0) ^ 2.0)";
    Function function = new Power(new Division(new Value(27), new Value(6)), new Value(2));
    final String result = printVisitor.visitPower((Power) function);

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction6() {
    final String expected = "(|value| - 8.0)";
    Function absolute = new Absolut(new Variable("value"));
    Function function = new Subtract(absolute, new Value(8));
    final String result = printVisitor.visitSubtract((Subtract) function);

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction7() {
    final String expected = "(|value| - 8.0)";
    Function absolute = new Absolut(new Variable("value"));
    Function function = new Subtract(absolute, new Value(8));
    final String result = printVisitor.visitSubtract((Subtract) function);

    assertThat(result, equalTo(expected));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldPrintFunction8() {
    final String expected = "((5.0 - i) * 8.0)";
    Function function = new Multiplication(new Subtract(new Value(5), new Variable("i")), new Value(8));
    final String result = printVisitor.visitMultiplication((Multiplication) function);

    assertThat(result, equalTo(expected));
  }
}
