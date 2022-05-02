package relatedException.studentModelException;

public class InvalidDateOfBirthException extends Exception{
    public InvalidDateOfBirthException() {
    }

    public InvalidDateOfBirthException(String s) {
        super(s);
    }

    public InvalidDateOfBirthException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
