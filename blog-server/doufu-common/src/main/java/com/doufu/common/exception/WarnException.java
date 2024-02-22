package com.doufu.common.exception;

import com.doufu.common.constant.HttpStatus;
import lombok.Getter;

/**
 * 警告异常
 *
 * @author doufu
 */
@Getter
public final class WarnException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    private final Integer code = HttpStatus.WARN;
    ;

    /**
     * 错误提示
     */
    private String message;


    /**
     * 空构造方法，避免反序列化问题
     */
    public WarnException() {
    }

    public WarnException(String message) {
        this.message = message;
    }


    @Override
    public String getMessage() {
        return message;
    }

    public WarnException setMessage(String message) {
        this.message = message;
        return this;
    }

}
