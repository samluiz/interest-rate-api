package ibm.samuelluiz.interestrateapi.exceptions.services;

public class DatabaseConstraintException extends RuntimeException {
    public DatabaseConstraintException(String msg) {
        super(msg);
    }
}
