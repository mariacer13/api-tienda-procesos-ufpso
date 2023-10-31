package com.api.ufpso.tienda.util;

import lombok.Getter;

@Getter
public enum Constants {
    CATEGORY_NOT_FOUND("Category not found");

    private String message;
    Constants(String s) {
        this.message=s;
    }
}
