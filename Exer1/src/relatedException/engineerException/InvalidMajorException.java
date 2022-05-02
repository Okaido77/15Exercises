package relatedException.engineerException;

public class InvalidMajorException extends RuntimeException{
    public InvalidMajorException() {
        super("Invalid Major");
    }

    public InvalidMajorException(String s) {
        super(s);
    }
}
