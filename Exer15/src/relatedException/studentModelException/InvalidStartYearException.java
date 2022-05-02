package relatedException.studentModelException;

public class InvalidStartYearException extends Exception{
    public InvalidStartYearException() {
    }

    public InvalidStartYearException(String s) {
        super(s);
    }

    public InvalidStartYearException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
