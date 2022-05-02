package relatedException;

public class InvalidNameException extends RuntimeException{

    public InvalidNameException() {
        super("Invalid Name Format");
    }

    public InvalidNameException(String s) {
        super(s);
    }
}
