/**
 * Created by pcaire on 2/11/17.
 */
public interface Calculator<T> {
    public T EvalExpression(String expression);
    public T Add(T a, T b);
    public T Subtract(T a, T b);
    public T Multiply(T a , T b);
    public T Divide(T a, T b);
    public T Modulo(T a , T b);
}
