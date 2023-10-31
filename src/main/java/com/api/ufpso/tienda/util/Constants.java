package com.api.ufpso.tienda.util;

import lombok.Getter;

@Getter
public enum Constants {
    ARTICULO_NOT_FOUND("Articulo not found"),
    ARTICULO_IS_NULL("Articulo is null");

    private String message;
    Constants(String s){
        this.message=s;
    }

}
