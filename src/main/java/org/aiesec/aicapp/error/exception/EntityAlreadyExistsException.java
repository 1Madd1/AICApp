package org.aiesec.aicapp.error.exception;

import org.aiesec.aicapp.error.ErrorCodes;

public class EntityAlreadyExistsException extends AICAppException {
    public EntityAlreadyExistsException(String m) {
        super(ErrorCodes.ENTITY_ALREADY_EXISTS, m);
    }
}
