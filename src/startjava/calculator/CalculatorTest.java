package startjava.calculator;

import java.io.Console;
import java.text.DecimalFormat;

public class CalculatorTest {
    private final Console console;
    private final DecimalFormat resultFormatter;

    public CalculatorTest(Console console) {
        this.console = console;
        this.resultFormatter = new DecimalFormat("#.###");
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

    private void displayAnswer(int a, int b, char op, double result) {
        System.out.printf("%d %c %d = %s%n", a, op, b, resultFormatter.format(result));
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