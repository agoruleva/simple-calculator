package startjava.calculator;

public class Calculator {
    public static final String OPERATORS_LIST = "+, -, *, /, ^, %";

    public static double evaluate(int a, int b, char op) {
        return switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '^' -> Math.pow(a, b);
            case '/' -> (double) a / b;
            case '%' -> Math.floorMod(a, b);
            default -> throw new IllegalArgumentException(String.valueOf(op));
        };
    }
}