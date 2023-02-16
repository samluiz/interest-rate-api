package ibm.samuelluiz.interestrateapi.exceptions.services;

import java.util.UUID;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(UUID uuid) {
        super("Object with UUID: " + uuid + " not found.");
    }
}
