package startjava.calculator;

import java.io.Console;

public class CalculatorTest {
    private final Console console;

    public CalculatorTest(Console console) {
        this.console = console;
    }

    public void run() {
        String answer = "yes";
        do {
            if (!"yes".equals(answer)) {
                continue;
            }
            evaluate();
        } while (!"no".equals(answer = askContinue()));
    }

    private void evaluate() {
        try {
            int a = Integer.parseInt(console.readLine("Введите первое число: "));
            char op = console.readLine("Введите знак операции (%s): ", Calculator.OPERATORS_LIST).charAt(0);
            int b = Integer.parseInt(console.readLine("Введите второе число: "));
            displayAnswer(a, b, op, Calculator.evaluate(a, b, op));
        } catch (ArithmeticException e) {
            displayError("нельзя делить на ноль");
        } catch (NumberFormatException e) {
            displayError("введено неправильное значение");
        } catch (IllegalArgumentException e) {
            displayError(String.format("""
                            операция '%s' не поддeрживается.
                            Доступны следующие операции: %s""",
                    e.getMessage(), Calculator.OPERATORS_LIST));
        }
    }

    private String askContinue() {
        return console.readLine("Хотите продолжить вычисления? [yes/no]: ").toLowerCase();
    }

    private static void displayAnswer(int a, int b, char op, int result) {
        final String format = "%d %c %d = " + (Calculator.isNegativePower(op, b) ? "1/%d" : "%d") + "%n";
        System.out.printf(format, a, op, b, result);
    }

    private static void displayError(String message) {
        System.out.println("Ошибка: " + message);
    }

    public static void main(String[] args) {
        Console console = System.console();
        if (console == null) {
            displayError(String.format("консоль не доступна.%nНевозможно запустить калькулятор."));
            System.exit(1);
        }

        new CalculatorTest(console).run();
    }
}