package relatedException.workerException;

public class InvalidJobException extends RuntimeException{
    public InvalidJobException() {
        super("Invalid Job");
    }

    public InvalidJobException(String s) {
        super(s);
    }
}
