import java.util.Scanner;

public class CalculatorTest {
    private final Scanner scanner = new Scanner(System.in);

    public void run() {
        do {
            evaluate();
        } while ("yes".equals(askContinue()));
    }

    private void evaluate() {
        try {
            System.out.print("Введите первое число: ");
            int a = Integer.parseInt(scanner.nextLine());
            System.out.print("Введите знак математической операции: ");
            char op = scanner.nextLine().charAt(0);
            System.out.print("Введите второе число: ");
            int b = Integer.parseInt(scanner.nextLine());
            System.out.println("Результат: " + Calculator.evaluate(a, b, op));
        } catch (ArithmeticException e) {
            System.out.println("На ноль делить нельзя");
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели неправильное значение");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private String askContinue() {
        String answer;
        do {
            System.out.print("Хотите продолжить вычисления? [yes/no]: ");
            answer = scanner.nextLine().toLowerCase();
        } while (!("yes".equals(answer) || "no".equals(answer)));
        return answer;
    }

    public static void main(String[] args) {
        new CalculatorTest().run();
    }
}