package relatedException;

public class InvalidGradeException extends RuntimeException{

    public InvalidGradeException() {
        super("Invalid Grade");
    }

    public InvalidGradeException(String s) {
        super(s);
    }
}
