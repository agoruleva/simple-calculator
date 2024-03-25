public class Calculator {
    public static int evaluate(int a, int b, char op) {
        return switch(op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            default -> throw new IllegalArgumentException("Неизвестная операция");
        };
    }
}