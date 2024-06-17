package startjava.calculator;

import java.io.Console;
import java.text.DecimalFormat;

public class CalculatorTest {
    private static final String PROMPT = "Хотите продолжить вычисления? [yes/no]: ";
    private static final String ALT_PROMPT = "Введите корректный ответ [yes/no]: ";
    private static final String NO = "no";
    private static final String YES = "yes";

    private final Console console;
    private final DecimalFormat resultFormatter;

    public CalculatorTest(Console console) {
        this.console = console;
        this.resultFormatter = new DecimalFormat("#.###");
    }

    public void run() {
        String answer = YES;
        do {
            if (!YES.equals(answer)) {
                continue;
            }
            evaluate();
        } while (!NO.equals(answer = askContinue(answer)));
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

    private String askContinue(String previous) {
        return console.readLine(YES.equals(previous) ? PROMPT : ALT_PROMPT).toLowerCase();
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