package com.blurooo.chapter4_1.exception;

import org.springframework.security.core.AuthenticationException;

public class VerificationCodeException extends AuthenticationException {

    public VerificationCodeException () {
        super("图形验证码校验失败");
    }

}
