import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by pcaire on 2/11/17.
 */
public class CalculatorTest {
    private CalculatorImp calculator = new CalculatorImp();

    @Test
    public void testEvalExpression(){
        Float actuals = calculator.EvalExpression("31*32-43");
        assertEquals(949.0, actuals, 0.02);

        actuals = calculator.EvalExpression("31-32*43");
        assertEquals(-1345, actuals, 0.02);
    }
}
