package relatedException.studentException;

public class InvalidFullNameException extends Exception{
    public InvalidFullNameException() {
        super("Họ tên sinh viên có chiều dài tối đa là 50 ký tự và tổi thiểu là 10 ký tự");
    }

    public InvalidFullNameException(String s) {
        super(s);
    }
}
