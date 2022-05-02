package relatedException.candidateException;

public class InvalidGenderException extends RuntimeException{
    public InvalidGenderException() {
        super("Invalid Gender");
    }

    public InvalidGenderException(String s) {
        super(s);
    }
}
