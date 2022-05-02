package relatedException.studentException;

public class InvalidPhoneNumberException extends Exception{
    public InvalidPhoneNumberException() {
        super(" phải là chuỗi số có chiều dài 10 ký tự và phải bắt đầu bằng một trong các chuỗi số: 090, 098, 091, 031, 035 hoặc 038.");
    }

    public InvalidPhoneNumberException(String s) {
        super(s);
    }
}
