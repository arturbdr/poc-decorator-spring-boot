package com.poc.springboot.decorator.decorators;

import com.poc.springboot.decorator.MyInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class LogDecorator<IN, OUT> implements MyInterface<IN, OUT> {

    private final MyInterface<IN, OUT> myInterface;

    @Override
    public OUT execute(IN in) {
        log.info("Input {}", in);
        return myInterface.execute(in);
    }
}
