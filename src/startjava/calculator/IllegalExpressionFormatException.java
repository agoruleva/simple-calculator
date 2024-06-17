package startjava.calculator;

public class IllegalExpressionFormatException extends IllegalArgumentException {
    public IllegalExpressionFormatException(String s) {
        super(s);
    }

    public IllegalExpressionFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
