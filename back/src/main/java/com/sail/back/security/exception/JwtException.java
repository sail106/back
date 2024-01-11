package com.sail.back.security.exception;


import lombok.Getter;

@Getter
public class JwtException extends RuntimeException{

    private final JwtErrorCode jwtErrorCode;

    public JwtException(JwtErrorCode jwtErrorCode, String e){
        super(e);
        this.jwtErrorCode=jwtErrorCode;
    }

}
