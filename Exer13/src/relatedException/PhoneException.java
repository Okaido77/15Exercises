package relatedException;

public class PhoneException extends RuntimeException{
    public PhoneException() {
    }

    public PhoneException(String s) {
        super(s);
    }

    public PhoneException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
