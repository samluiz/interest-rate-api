package ibm.samuelluiz.interestrateapi.exceptions.services;

public class InvalidQueryException extends RuntimeException {
    public InvalidQueryException(String msg) {
        super(msg);
    }
}
