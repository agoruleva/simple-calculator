package startjava.calculator;

public class Calculator {
    public static final String OPERATORS_LIST = "+, -, *, /, ^, %";

    public static int evaluate(int a, int b, char op) {
        return switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '^' -> pow(a, Math.abs(b));
            case '/' -> a / b;
            case '%' -> a % b;
            default -> throw new IllegalArgumentException(String.valueOf(op));
        };
    }

    public static boolean isNegativePower(char op, int power) {
        return op == '^' && power < 0;
    }

    private static int pow(int a, int b) {
        int result = 1;
        for (int i = 1; i <= b; ++i) {
            result *= a;
        }
        return result;
    }
}