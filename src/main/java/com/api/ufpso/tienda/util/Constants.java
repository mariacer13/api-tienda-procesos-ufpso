package com.api.ufpso.tienda.util;

import lombok.Getter;

@Getter
public enum Constants {
    ARTICLE_NOT_FOUND("Article not found"),
    ARTICLE_IS_NULL("Article is null");

    private String message;
    Constants(String s){
        this.message=s;
    }

}
