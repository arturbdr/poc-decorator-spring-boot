package com.poc.springboot.decorator;

import com.poc.springboot.decorator.decorators.DurationDecorator;
import com.poc.springboot.decorator.decorators.LogDecorator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeansConfiguration implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MyInterface<?, ?>) {
            return new DurationDecorator<>(new LogDecorator<>((MyInterface<?, ?>) bean));
        }
        return bean;
    }
}
