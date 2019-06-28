package com.poc.springboot.decorator;

public interface MyInterface<IN, OUT> {

    OUT execute(IN in);
}
