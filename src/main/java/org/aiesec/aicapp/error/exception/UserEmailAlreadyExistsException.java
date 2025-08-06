package org.aiesec.aicapp.error.exception;

import org.aiesec.aicapp.error.ErrorCodes;

public class UserEmailAlreadyExistsException extends AICAppException {
    public UserEmailAlreadyExistsException(String m) {
        super(ErrorCodes.USER_EMAIL_ALREADY_EXISTS, m);
    }
}
