package az.ingress.ms10demo1.controller;

import az.ingress.ms10demo1.dto.StudentDto;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {

    // query params
    @GetMapping("/en2")
    public String sayHello2(@RequestParam(name = "name") String name, @RequestParam String lastName) {
        return "Hello : " + name + " " + lastName;
    }

    // object as query param
    @GetMapping("/en")
    public String sayHello( StudentDto studentDto) {
        return "Hello Spring " + studentDto;
    }

    // request headers
    @GetMapping("/az")
    public String sayHelloAz(
            @RequestHeader("course") String course,
            @RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) String lang) {
        return "Salam Spring " + lang + " " + course;
    }

    // path variable
    @GetMapping("/age/{age}/size/{size}")
    public String sayHelloAge(@PathVariable Long age, @PathVariable Long size) {
        return "Salam Spring " + age + " size " + size;
    }
}
