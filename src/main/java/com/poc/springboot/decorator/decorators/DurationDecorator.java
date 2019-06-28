package com.poc.springboot.decorator.decorators;

import com.poc.springboot.decorator.MyInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

@RequiredArgsConstructor
@Slf4j
public class DurationDecorator<IN, OUT> implements MyInterface<IN, OUT> {

    private final MyInterface<IN, OUT> myInterface;

    @Override
    public OUT execute(IN in) {
        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        try {
            return myInterface.execute(in);
        } finally {
            stopWatch.stop();
            long totalTimeMillis = stopWatch.getTotalTimeMillis();
            log.info("Processing time in {}", totalTimeMillis);
        }
    }
}
