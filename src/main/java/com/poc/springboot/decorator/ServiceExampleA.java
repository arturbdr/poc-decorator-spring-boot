package com.poc.springboot.decorator;

import com.poc.springboot.decorator.dto.MyRequestObjectA;
import com.poc.springboot.decorator.dto.MyResponseObjectA;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ServiceExampleA implements MyInterface<MyRequestObjectA, MyResponseObjectA> {

    @Override
    public MyResponseObjectA execute(final MyRequestObjectA myRequestObjectA) {
        return MyResponseObjectA.builder()
                .age(myRequestObjectA.getAge() + 1)
                .name(myRequestObjectA.getName() + "SampleA")
                .build();
    }
}
