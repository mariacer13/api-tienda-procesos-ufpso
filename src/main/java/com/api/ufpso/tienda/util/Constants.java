package com.api.ufpso.tienda.util;

import lombok.Getter;

@Getter
public enum Constants {
    CATEGORY_NOT_FOUND("Category not found"),
    ARTICLE_NOT_FOUND("Article not found"),
    ARTICLE_IS_NULL("Article is null"),

    ADDRESS_NOT_FOUND("Address not found"),
    USER_NOT_FOUND("User not found"),
    USER_IS_NULL("User is null");

    private String message;
    Constants(String s){
        this.message=s;
    }
}
