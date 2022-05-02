package relatedException;

public class InvalidIDException extends RuntimeException{
    public InvalidIDException() {
        super("Invalid ID Format");
    }

    public InvalidIDException(String s) {
        super(s);
    }
}
