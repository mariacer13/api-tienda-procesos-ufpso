package com.api.ufpso.tienda.security;

import lombok.Data;

@Data
public class AuthCredentials {
    private String email;
    private String password;
}
