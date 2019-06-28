package com.poc.springboot.decorator;

import com.poc.springboot.decorator.dto.MyRequestObjectB;
import com.poc.springboot.decorator.dto.MyResponseObjectB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ServiceExampleB implements MyInterface<MyRequestObjectB, MyResponseObjectB> {

    @Override
    public MyResponseObjectB execute(final MyRequestObjectB myRequestObjectB) {
        return MyResponseObjectB.builder()
                .age(myRequestObjectB.getAge() + 2)
                .name(myRequestObjectB.getName() + "SampleB")
                .build();
    }
}
