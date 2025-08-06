package org.aiesec.aicapp.error.exception;

import lombok.Getter;

@Getter
public class AICAppException extends RuntimeException {
    private final String code;
    private final String message;

    public AICAppException(String c, String m) {
        super(m);
        this.code = c;
        this.message = m;
    }
}
