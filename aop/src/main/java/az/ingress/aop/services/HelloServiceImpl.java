package az.ingress.aop.services;

import az.ingress.aop.controller.Dto;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Slf4j
public class HelloServiceImpl implements HelloService {

    @SneakyThrows
    @Override
    public Dto sayHello(String language) {
        log.info("");
        Thread.sleep(new Random().nextInt(1000));
        return new Dto("Hello World");
    }

    @SneakyThrows
    @Override
    public Dto sayHello2() {
        Thread.sleep(new Random().nextInt(1000));
        return new Dto("Hello World");
    }

    @SneakyThrows
    @Override
    public Dto sayHello3() {
        Thread.sleep(new Random().nextInt(1000));
        return new Dto("Hello World");
    }
}
