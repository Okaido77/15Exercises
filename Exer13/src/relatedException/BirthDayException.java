package relatedException;

public class BirthDayException extends RuntimeException{
    public BirthDayException() {
    }

    public BirthDayException(String s) {
        super(s);
    }

    public BirthDayException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
