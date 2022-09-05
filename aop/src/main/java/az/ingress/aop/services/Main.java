package az.ingress.aop.services;

public class Main {

    public static void main(String[] args) {
        Service1 service1 = new Service1Proxy();
        service1.sayHello0();
    }
}
