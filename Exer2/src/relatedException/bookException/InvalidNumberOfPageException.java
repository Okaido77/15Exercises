package relatedException.bookException;

public class InvalidNumberOfPageException extends Exception{
    public InvalidNumberOfPageException() {
        super("Invalid Number Of book");
    }

    public InvalidNumberOfPageException(String s) {
        super(s);
    }
}
