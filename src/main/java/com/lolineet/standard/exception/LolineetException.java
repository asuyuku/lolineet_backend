package com.lolineet.standard.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author YUKI.N
 * @since 2023-01-09
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LolineetException extends RuntimeException {
    private static final long serialVersionUID = 7285694384926860231L;

    private int code;
    private String message;
    private String detail;

    public LolineetException(String message){
        this(500,message,message);
    }

    public LolineetException(int code, String message) {
        this(code, message, message);
    }

    public LolineetException(int code, String message, String detail) {
        super(message);
        this.code = code;
        this.message = message;
        this.detail = detail;
    }

}
