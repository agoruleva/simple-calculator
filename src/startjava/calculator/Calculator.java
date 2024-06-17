package startjava.calculator;

public class Calculator {
    private static final String OPERATORS_LIST = "+, -, *, /, ^, %";
    private static final int EXPRESSION_LENGTH = 3;

    public static double evaluate(String[] expression) {
        if (expression.length != EXPRESSION_LENGTH) {
            throw new IllegalExpressionFormatException("""
                    неверный формат выражения (%d).
                    Используйте <операнд> <операция> <операнд>""".formatted(expression.length));
        }

        int a = Integer.parseInt(expression[0]);
        String op = expression[1];
        int b = Integer.parseInt(expression[2]);
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "^" -> Math.pow(a, b);
            case "/", "%" -> {
                if (b == 0) {
                    throw new ArithmeticException("нельзя делить на 0");
                }
                yield "/".equals(op) ? (double) a / b : (double) (a % b);
            }
            default -> throw new IllegalOperationException("""
                    операция '%s' не поддерживается.
                    Доступны следующие операции: %s""".formatted(op, OPERATORS_LIST));
        };
    }
}