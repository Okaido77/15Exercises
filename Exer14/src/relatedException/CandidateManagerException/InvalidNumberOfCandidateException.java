package relatedException.CandidateManagerException;

public class InvalidNumberOfCandidateException extends Exception{
    public InvalidNumberOfCandidateException() {
        super("Invalid Number Of Selected Candidate");
        // 11 - 15 allowed
    }

    public InvalidNumberOfCandidateException(String s) {
        super(s);
    }
}
