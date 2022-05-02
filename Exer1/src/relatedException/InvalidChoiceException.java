package relatedException;

public class InvalidChoiceException extends RuntimeException{
    public InvalidChoiceException() {
        super("no choice found");
    }

    public InvalidChoiceException(String s) {
        super(s);
    }
}
