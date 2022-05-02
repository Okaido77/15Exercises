package relatedException.newspaperException;

public class InvalidReleaseNumberException extends Exception{
    public InvalidReleaseNumberException() {
        super("Invalid Release Number");
    }

    public InvalidReleaseNumberException(String s) {
        super(s);
    }
}
