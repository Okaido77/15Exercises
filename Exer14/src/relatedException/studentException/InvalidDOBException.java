package relatedException.studentException;

public class InvalidDOBException extends Exception{
    public InvalidDOBException() {
        super("sai định dạng ngày tháng năm dd/MM/YYYY");
    }

    public InvalidDOBException(String s) {
        super(s);
    }

    public InvalidDOBException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
