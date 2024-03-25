public class Calculator {
    public static void main(String[] args) {
        int firstOperand = 8;
        int secondOperand = 4;
        char operator = '+';
        int result = 0;
        boolean error = false;
        if (operator == '+') {
            result = firstOperand + secondOperand;
        } else if (operator == '-') {
            result = firstOperand - secondOperand;
        } else if (operator == '*') {
            result = firstOperand * secondOperand;
        } else if (operator == '^') {
            result = 1;
            for (int i = 1; i <= secondOperand; ++i) {
                result *= firstOperand;
            }
        } else if (operator == '/' || operator == '%') {
            if (secondOperand == 0) {
                System.out.println("Ошибка: на 0 делить нельзя!");
                error = true;
            } else {
                if (operator == '/') {
                    result = firstOperand / secondOperand;
                } else {
                    result = firstOperand % secondOperand;
                }
            }
        }
        if (!error) {
            System.out.println(firstOperand + " " + operator + " " + secondOperand + " = " + result);
        }
    }
}