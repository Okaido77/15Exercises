package relatedException;

public class FullNameException extends RuntimeException{
    public FullNameException() {
    }

    public FullNameException(String s) {
        super(s);
    }

    public FullNameException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
