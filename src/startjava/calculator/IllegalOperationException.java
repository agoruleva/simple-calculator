package startjava.calculator;

public class IllegalOperationException extends IllegalArgumentException {
    public IllegalOperationException(String s) {
        super(s);
    }

    public IllegalOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}
