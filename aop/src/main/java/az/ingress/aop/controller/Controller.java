package az.ingress.aop.controller;

import az.ingress.aop.services.HelloServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@RequiredArgsConstructor
public class Controller {

    private final HelloServiceImpl service;

    @GetMapping("/1")
    public Dto sayHello() {
        return service.sayHello("english");
    }

    @GetMapping("/2")
    public Dto sayHello2() {
        return service.sayHello2();
    }

    @GetMapping("/3")
    public Dto sayHello3() {
        return service.sayHello3();
    }
}
