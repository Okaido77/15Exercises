package relatedException.studentModelException;

public class InvalidGradeException extends Exception{
    public InvalidGradeException() {
    }

    public InvalidGradeException(String s) {
        super(s);
    }

    public InvalidGradeException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
