package relatedException.candidateException;

public class InvalidAgeException extends RuntimeException{
    public InvalidAgeException() {
        super("Invalid Age");
    }

    public InvalidAgeException(String s) {
        super(s);
    }
}
