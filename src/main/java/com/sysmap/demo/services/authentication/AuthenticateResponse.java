package com.sysmap.demo.services.authentication;

import lombok.Data;

import java.util.UUID;

@Data
public class AuthenticateResponse {
    public UUID userId;
    public String token;
}