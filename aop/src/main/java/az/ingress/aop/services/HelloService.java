package az.ingress.aop.services;

import az.ingress.aop.controller.Dto;

public interface HelloService {

    Dto sayHello(String language);

    Dto sayHello2();

    Dto sayHello3();
}
