package relatedException.candidateException;

public class InvalidNameException extends RuntimeException{
    public InvalidNameException() {
        super("Invalid Name");
    }

    public InvalidNameException(String s) {
        super(s);
    }
}
