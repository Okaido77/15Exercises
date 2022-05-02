package relatedException.newspaperException;

public class InvalidReleaseMonthException extends Exception{
    public InvalidReleaseMonthException() {
        super("Invalid Release Month");
    }

    public InvalidReleaseMonthException(String s) {
        super(s);
    }
}
