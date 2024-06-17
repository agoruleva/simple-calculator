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
        final String[] expression = console.readLine("Введите математическое выражение: ").split("\\s+");
        try {
            displayAnswer(expression, Calculator.evaluate(expression));
        } catch (NumberFormatException e) {
            displayError("введено неправильное значение");
        } catch (IllegalArgumentException | ArithmeticException e) {
            displayError(e.getMessage());
        }
    }

    private String askContinue() {
        return console.readLine("Хотите продолжить вычисления? [yes/no]: ").toLowerCase();
    }

    private void displayAnswer(String[] expression, double result) {
        System.out.printf("%s %s %s = %s%n", expression[0], expression[1], expression[2],
                resultFormatter.format(result));
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