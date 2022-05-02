package relatedException.bookException;

public class InvalidAuthorNameException extends RuntimeException{

    public InvalidAuthorNameException() {
        super("Invalid Name Format");
    }

    public InvalidAuthorNameException(String s) {
        super(s);
    }
}
