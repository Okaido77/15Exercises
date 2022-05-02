package relatedException.studentModelException;

public class InvalidNameException extends Exception{
    public InvalidNameException() {
    }

    public InvalidNameException(String s) {
        super(s);
    }

    public InvalidNameException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
