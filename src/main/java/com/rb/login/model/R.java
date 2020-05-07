package com.rb.login.model;

import lombok.Data;

@Data
public class R<T> {
    private String msg;
    private T data;

    public R(){}

    public R(String msg) {
        this.msg = msg;
    }
}
