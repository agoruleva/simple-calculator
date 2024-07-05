package startjava.calculator;

public class Calculator {
    private static final String OPERATORS_LIST = "+, -, *, /, ^, %";
    private static final int EXPRESSION_LENGTH = 3;

    private Calculator() {
    }

    public static double evaluate(String expression) {
        final String[] expressionParts = expression.split("\\s+");
        if (expressionParts.length != EXPRESSION_LENGTH) {
            throw new IllegalExpressionFormatException("""
                    неверный формат выражения (%d).
                    Используйте <операнд> <операция> <операнд>""".formatted(expressionParts.length));
        }

        int a = Integer.parseInt(expressionParts[0]);
        String op = expressionParts[1];
        int b = Integer.parseInt(expressionParts[2]);
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