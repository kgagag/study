package com.gray.common;

import org.springframework.util.Assert;

/**
 * 自定义业务异常基类。
 * 
 * @author Luffy
 *
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -2996312694401870967L;

    /**
     * 异常消息
     */
    private ErrorStatus error;

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public BusinessException(final ErrorStatus error) {
        Assert.notNull(error);
        this.error = error;
    }

    public ErrorStatus getError() {
        return error;
    }

    @Override
    public String getMessage() {
        if (this.error != null) {
            return this.error.getReasonPhrase();
        }
        return super.getMessage();
    }

    @Override
    public String toString() {
        if (error != null) {
            return error.toString();
        }
        return super.toString();
    }

}
