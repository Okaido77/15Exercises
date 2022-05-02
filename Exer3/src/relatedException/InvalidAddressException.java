package relatedException;

public class InvalidAddressException extends RuntimeException{
    public InvalidAddressException() {
        super("Invalid Address ");
    }

    public InvalidAddressException(String s) {
        super(s);
    }
}
