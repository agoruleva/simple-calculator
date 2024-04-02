public class Calculator {
    public static int evaluate(int a, int b, char op) {
        return switch(op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '^' -> pow(a, b);
            case '/' -> a / b;
            case '%' -> a % b;
            default -> throw new IllegalArgumentException("Неизвестная операция");
        };
    }

    private static int pow(int a, int b) {
        int result = 1;
        for (int i = 1; i <= b; ++i) {
            result *= a;
        }
        return result;
    }
}