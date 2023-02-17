package ibm.samuelluiz.interestrateapi.exceptions.services;

import java.util.UUID;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String uuid) {
        super("Objeto com UUID: " + uuid + " não existe.");
    }
}
