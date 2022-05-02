package relatedException.staffException;

public class InvalidLevelException extends RuntimeException{
    public InvalidLevelException() {
        super("Invalid Level");
    }

    public InvalidLevelException(String s) {
        super(s);
    }
}
