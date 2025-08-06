package org.aiesec.aicapp.error.exception;

import org.aiesec.aicapp.error.ErrorCodes;

public class NoDataException extends AICAppException {
    public NoDataException(String m) {
        super(ErrorCodes.ENTITY_NOT_FOUND, m);
    }
}
