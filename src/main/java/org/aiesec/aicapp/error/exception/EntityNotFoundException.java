package org.aiesec.aicapp.error.exception;

import org.aiesec.aicapp.error.ErrorCodes;

public class EntityNotFoundException extends AICAppException {
    public EntityNotFoundException(String m) {
        super(ErrorCodes.ENTITY_NOT_FOUND, m);
    }
}
