import java.util.Stack;

/**
 * Created by pcaire on 2/11/17.
 */
public class CalculatorImp implements Calculator<Float> {
    private Float result;

    @Override
    public Float EvalExpression(String expression) {
        Stack<Float> stack = new Stack<>();
        char last_operator = '+';
        int i = 0;
        int j = 0;
        while (j < expression.length()){
            while(j < expression.length() && (Character.isDigit(expression.charAt(j)) ||
                    expression.charAt(j) == '.'))
                j++;
            String operand_str = expression.substring(i, j);
            float operand = Float.parseFloat(operand_str);
            if(last_operator == '*'){
                float a = stack.pop();
                stack.push(a*operand);
            }
            else if(last_operator == '/'){
                float a = stack.pop();
                stack.push(a/operand);
            }
            else if(last_operator == '-'){
                operand = -1 * operand;
                stack.push(operand);
            }
            else
                stack.push(operand);
            i = j;
            while(j < expression.length() &&  !Character.isDigit(expression.charAt(j)) &&
                    expression.charAt(j) != '.')
                j++;
            String operator = expression.substring(i, j);
            i = j;
            if(operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")
                    || operator.equals("")) {
                if(!operator.equals(""))
                    last_operator = operator.charAt(0);
            }
            else {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        float result = (float) 0.0;
        while(!stack.empty()){
            result += stack.pop();
        }
        return result;
    }

    @Override
    public Float Add(Float a, Float b) {
        result = a+b;
        return result;
    }

    @Override
    public Float Subtract(Float a, Float b) {
        result = a-b;
        return result;
    }

    @Override
    public Float Multiply(Float a, Float b) {
        result = a*b;
        return result;
    }

    @Override
    public Float Divide(Float a, Float b) {
        if(b != 0)
            result = a/b;
        return result;
    }

    @Override
    public Float Modulo(Float a, Float b) {
        result = Float.valueOf(a%b);
        return result;
    }
}
