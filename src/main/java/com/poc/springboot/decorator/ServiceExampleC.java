package com.poc.springboot.decorator;

import com.poc.springboot.decorator.dto.MyRequestObjectC;
import com.poc.springboot.decorator.dto.MyResponseObjectC;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ServiceExampleC implements MyInterface<MyRequestObjectC, MyResponseObjectC> {

    @Override
    public MyResponseObjectC execute(final MyRequestObjectC myRequestObjectA) {
        return MyResponseObjectC.builder()
                .age(myRequestObjectA.getAge() + 2)
                .name(myRequestObjectA.getName() + "SampleC")
                .build();
    }
}
