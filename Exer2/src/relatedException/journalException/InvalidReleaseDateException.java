package relatedException.journalException;

public class InvalidReleaseDateException extends Exception{
    public InvalidReleaseDateException() {
        super("Invalid Release Date");
    }

    public InvalidReleaseDateException(String s) {
        super(s);
    }
}
