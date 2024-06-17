package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.Visitor.CalculateVisitor;
import org.junit.jupiter.api.Test;

public class ResolutionTest {

  CalculateVisitor calculateVisitor = new CalculateVisitor();

  /** Case 1 + 6 */
  @Test
  public void shouldResolveSimpleFunction1() {
    Addition addition = new Addition(new Value(1), new Value(6));
    Double result = addition.accept(calculateVisitor);

    assertThat(result, equalTo(7.0));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldResolveSimpleFunction2() {
    Division division = new Division(new Value(12), new Value(2));
    Double result = division.accept(calculateVisitor);

    assertThat(result, equalTo(6.0));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldResolveSimpleFunction3() {
    Multiplication multiplication =
        new Multiplication(new Division(new Value(9), new Value(2)), new Value(3));
    final Double result = multiplication.accept(calculateVisitor);

    assertThat(result, equalTo(13.5));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldResolveSimpleFunction4() {
    Power power = new Power(new Division(new Value(27), new Value(6)), new Value(2));
    final Double result = power.accept(calculateVisitor);

    assertThat(result, equalTo(20.25));
  }

  /** Case 36 ^ (1/2) */
  @Test
  public void shouldResolveSimpleFunction5() {
    Power power = new Power(new Value(36), new Division(new Value(1), new Value(2)));
    final Double result = power.accept(calculateVisitor);

    assertThat(result, equalTo(6.0));
  }

  /** Case |136| */
  @Test
  public void shouldResolveSimpleFunction6() {
    Absolut absolute = new Absolut(new Value(136));
    final Double result = absolute.accept(calculateVisitor);

    assertThat(result, equalTo(136.0));
  }

  /** Case |-136| */
  @Test
  public void shouldResolveSimpleFunction7() {
    Absolut absolute = new Absolut(new Value(-136));
    final Double result = absolute.accept(calculateVisitor);

    assertThat(result, equalTo(136.0));
  }

  /** Case (5 - 5) * 8 */
  @Test
  public void shouldResolveSimpleFunction8() {
    Subtract subtract = new Subtract(new Value(5), new Value(5));
    Multiplication multiplication = new Multiplication(subtract, new Value(8));
    final Double result = multiplication.accept(calculateVisitor);

    assertThat(result, equalTo(0.0));
  }

  /** Case sqrt(25) */
  @Test
  public void shouldResolveSimpleFunction9() {
    SquareRoot squareRoot = new SquareRoot(new Value(25));
    final Double result = squareRoot.accept(calculateVisitor);

    assertThat(result, equalTo(5.0));
  }
}
