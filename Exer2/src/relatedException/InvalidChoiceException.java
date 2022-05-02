package relatedException;

public class InvalidChoiceException extends Exception{
    public InvalidChoiceException() {
        super("Invalid Choice");
    }

    public InvalidChoiceException(String s) {
        super(s);
    }
}
