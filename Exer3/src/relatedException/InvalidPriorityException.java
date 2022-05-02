package relatedException;

public class InvalidPriorityException extends RuntimeException{
    public InvalidPriorityException() {
        super("Invalid Priority");
    }

    public InvalidPriorityException(String s) {
        super(s);
    }

    public InvalidPriorityException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
