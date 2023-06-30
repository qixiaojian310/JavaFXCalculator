import org.example.util.ExpressionEvaluator;
import org.junit.Test;

public class ExpressionTest {
    @Test
    public void test() {
        System.out.println(ExpressionEvaluator.evaluateExpression("3*(-3-3)"));
    }
}
