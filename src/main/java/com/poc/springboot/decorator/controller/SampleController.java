package com.poc.springboot.decorator.controller;

import com.poc.springboot.decorator.MyInterface;
import com.poc.springboot.decorator.dto.MyRequestObjectA;
import com.poc.springboot.decorator.dto.MyResponseObjectA;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SampleController {

    private final MyInterface<MyRequestObjectA, MyResponseObjectA> serviceExampleA;
    private final BeanFactory beanFactory;

    @PostMapping("/{name}/{age}")
    public ResponseEntity<MyResponseObjectA> getA(
            @PathVariable String name,
            @PathVariable Integer age) {


//        beanFactory.getBean(ServiceExampleA.class);
//        return null;
        final MyResponseObjectA execute = serviceExampleA.execute(MyRequestObjectA.builder().name(name).age(age).build());
        return ResponseEntity.ok(execute);
    }
}
