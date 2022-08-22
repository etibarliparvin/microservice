package az.ingress.ms10demo1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/second")
public class HelloController2 {

    @GetMapping
    public String sayHelloDefault() {
        return "Default Spring";
    }
}
